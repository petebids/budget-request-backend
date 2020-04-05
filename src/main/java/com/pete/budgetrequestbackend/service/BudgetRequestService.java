package com.pete.budgetrequestbackend.service;

import java.time.LocalDate;


import com.pete.budgetrequestbackend.model.BudgetRequest;
import com.pete.budgetrequestbackend.payload.CreateBudgetRequestPayload;
import com.pete.budgetrequestbackend.repository.BudgetRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BudgetRequestService{

    @Autowired
    BudgetRequestRepository budgetRequestRepository ;



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
    budgetRequest.setAllocationDate(getStartOfMonthFromNow(now)); 
    budgetRequest.setFinYear(getEndOfCurrentFinYearFromNow(now)); 
    budgetRequest.setCreatedDate(now);



    budgetRequestRepository.save(budgetRequest);
    return  ResponseEntity.status(HttpStatus.CREATED).body(budgetRequest);
    }

    private LocalDate getEndOfCurrentFinYearFromNow(LocalDate now){
        LocalDate endOfFinYearInThisCalendarYear = LocalDate.of(now.getYear() , 06, 30);
        if (now.isBefore(endOfFinYearInThisCalendarYear) || now.isEqual(endOfFinYearInThisCalendarYear)){
            return endOfFinYearInThisCalendarYear;
        }
        else{
            return LocalDate.of((endOfFinYearInThisCalendarYear.getYear()+1),endOfFinYearInThisCalendarYear.getMonthValue(), endOfFinYearInThisCalendarYear.getDayOfMonth());
        }
        
    }

    private LocalDate getStartOfMonthFromNow(LocalDate now){

        return LocalDate.of(now.getYear(), now.getMonthValue() , 1);

    }

}