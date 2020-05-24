package com.pete.budgetrequestbackend.repository;

import com.pete.budgetrequestbackend.model.BudgetRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BudgetRequestRepository extends CrudRepository<BudgetRequest , Long>, QueryByExampleExecutor<BudgetRequest>{
    
}

