package com.pete.budgetrequestbackend.service;

import java.time.LocalDate;

import com.pete.budgetrequestbackend.model.BudgetRequest;
import com.pete.budgetrequestbackend.payload.CreateBudgetRequestPayload;
import com.pete.budgetrequestbackend.repository.BudgetRequestRepository;
import com.pete.budgetrequestbackend.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BudgetRequestService{

    @Autowired
    BudgetRequestRepository budgetRequestRepository ;

    @Autowired
    DateUtil dateUtil; 



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


}