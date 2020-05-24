package com.pete.budgetrequestbackend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.pete.budgetrequestbackend.model.BudgetRequest;
import com.pete.budgetrequestbackend.payload.CreateBudgetRequestPayload;
import com.pete.budgetrequestbackend.repository.BudgetRequestRepository;
import com.pete.budgetrequestbackend.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BudgetRequestService{

    @Autowired
    BudgetRequestRepository budgetRequestRepository ;

    @Autowired
    DateUtil dateUtil; 

    @Value("$budgetrequests.alowable-query-params")
    final List<String> allowableQueryParams;


    public ResponseEntity<BudgetRequest> getByID(Long id){
        BudgetRequest budgetRequest = budgetRequestRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
        return ResponseEntity.status(HttpStatus.OK).body(budgetRequest);
    }

    public  ResponseEntity<List<BudgetRequest>> findAll(){
        List<BudgetRequest> budgetRequests = new ArrayList<BudgetRequest>();
        budgetRequestRepository.findAll().forEach(budgetRequests::add);
        if (budgetRequests.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND) ; 
        }
        return ResponseEntity.status(HttpStatus.OK).body(budgetRequests);
    }


    public ResponseEntity<List<BudgetRequest>> getAllByParams(Map<String, String> requestParams){
        for (String param : requestParams.keySet()) {
            if (!allowableQueryParams.contains(param)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "query param " +  param + " not supported ");
            }
        }
        List<BudgetRequest> budgetRequests = new ArrayList<BudgetRequest>();
        
        Example<BudgetRequest> example = buildExampleFromRequestParams(requestParams);
        budgetRequestRepository.findAll(example).forEach(budgetRequests::add);
        if (budgetRequests.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND) ; 
        }

        return ResponseEntity.status(HttpStatus.OK).body(budgetRequests);    
    }


    public ResponseEntity<BudgetRequest> createBudgetRequest(CreateBudgetRequestPayload payload){        

    //process inputs as they are 
    BudgetRequest budgetRequest = new BudgetRequest();
    budgetRequest.setBranchNumber(payload.getBranchNumber());
    budgetRequest.setCostCentre(payload.getCostCentre());
    budgetRequest.setFibreProjectManager(payload.getFibreProjectManager());
    budgetRequest.setProjectCode(payload.getProjectCode());
    budgetRequest.setProjectType(payload.getProjectType());
    budgetRequest.setProjectBudget(payload.getProjectBudget());
    budgetRequest.setProjectBudget(payload.getProjectBudget());
    budgetRequest.setRequestor(payload.getRequestor());
    budgetRequest.setState(payload.getState());
    
    // these attribures are defined by bus logic , they are generated here rather than expected to be part of they payload
    LocalDate now = LocalDate.now();
    budgetRequest.setAllocationDate(dateUtil.getStartOfMonthFromNow(now)); 
    budgetRequest.setFinYear(dateUtil.getEndOfCurrentFinYearFromNow(now)); 
    budgetRequest.setCreatedDate(now);



    budgetRequestRepository.save(budgetRequest);
    return  ResponseEntity.status(HttpStatus.CREATED).body(budgetRequest);
    }

    private Example<BudgetRequest> buildExampleFromRequestParams(Map<String, String> requestParams){
        BudgetRequest budgetRequest = new BudgetRequest();
        if (requestParams.containsKey("branchNumber")){
            budgetRequest.setBranchNumber(requestParams.get("branchNumber"));
        }
        if (requestParams.containsKey("costCentre")){
            budgetRequest.setCostCentre(requestParams.get("costCentre"));
        }
        Example<BudgetRequest>  example = Example.of(budgetRequest);
        return example;
    }


}