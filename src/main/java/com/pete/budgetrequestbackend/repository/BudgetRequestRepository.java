package com.pete.budgetrequestbackend.repository;

import com.pete.budgetrequestbackend.model.BudgetRequest;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRequestRepository extends CrudRepository<BudgetRequest , Long>{
    
}

