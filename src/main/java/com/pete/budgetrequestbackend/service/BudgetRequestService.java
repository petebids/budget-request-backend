package com.pete.budgetrequestbackend.service;

import java.util.Calendar;
import java.util.Date;

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
    budgetRequest.setProjectBudget(payload.getProjectBudget());
    budgetRequest.setProjectBudget(payload.getProjectBudget());
    budgetRequest.setRequestor(payload.getRequestor());
    budgetRequest.setState(payload.getState());
    
    // these attribures are defined by bus logic , they are generated here rather than expected to be part of they payload
    Date today = Calendar.getInstance().getTime();
    budgetRequest.setAllocationDate(today); //TODO verify bus logic for this
    budgetRequest.setFinYear(today); //TODO verify bus logic for this
    budgetRequest.setCreatedDate(today);



    budgetRequestRepository.save(budgetRequest);
    return  ResponseEntity.status(HttpStatus.CREATED).body(budgetRequest);
    }



}