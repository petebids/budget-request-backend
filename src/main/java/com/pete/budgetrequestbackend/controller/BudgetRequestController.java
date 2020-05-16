package com.pete.budgetrequestbackend.controller;

import com.pete.budgetrequestbackend.repository.BudgetRequestRepository;
import com.pete.budgetrequestbackend.service.BudgetRequestService;
import com.pete.budgetrequestbackend.payload.CreateBudgetRequestPayload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import javax.validation.Valid;

import com.pete.budgetrequestbackend.model.BudgetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class BudgetRequestController{
    private static final Logger logger = LoggerFactory.getLogger(BudgetRequestController.class);

    @Autowired
    BudgetRequestRepository budgetRequestRepository;

    @Autowired
    BudgetRequestService budgetRequestService;


    @GetMapping("/budgetrequest/")
    public Iterable<BudgetRequest> getAll(){
        return budgetRequestRepository.findAll();
    }

    @GetMapping("/budgetrequest/{id}")
    public Optional<BudgetRequest> getbyId(@PathVariable(value = "id") final Long budgetRequestId){
        return budgetRequestRepository.findById(budgetRequestId);
        
    }

    @PostMapping("/budgetrequest/")
    public ResponseEntity<BudgetRequest> createBudgetrequest(@Valid @RequestBody  CreateBudgetRequestPayload payload){
        return budgetRequestService.createBudgetRequest(payload);

    }

    @PatchMapping("/budgetrequest/{id}")
    public ResponseEntity<BudgetRequest> updatBudgetRequest(@PathVariable(value = "id") final Long budgetRequestId, @Valid @RequestBody final BudgetRequest budgetRequest){
        BudgetRequest updatedBudgetRequest = budgetRequestRepository.save(budgetRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBudgetRequest);
    }

    @DeleteMapping("/budgetrequest/{id}")
    public ResponseEntity<String> deleteBudgetrequest(@PathVariable(value = "id") final Long budgetRequestId){
        budgetRequestRepository.deleteById(budgetRequestId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sucessfully deleted budget request by id : " + budgetRequestId);
    }




}