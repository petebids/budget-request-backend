package com.pete.budgetrequestbackend.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import java.io.Serializable;


@Entity
public class BudgetRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date createdDate;
    private String projectCode;
    private String projectType;
    private Long projectBudget;
    private String costCentre;
    private String branchNumber;
    @JsonFormat(pattern="dd/MM/yyyy ")
    private Date allocationDate;
    @JsonFormat(pattern="dd/MM/yyyy ")

    private Date finYear;
    private String fibreProjectManager;
    private String state;

    private String requestor;


    public BudgetRequest() {
    }

    public BudgetRequest(Long id, Date createdDate, String projectCode, String projectType, Long projectBudget, String costCentre, String branchNumber, Date allocationDate, Date finYear, String fibreProjectManager, String state, String requestor) {
        this.id = id;
        this.createdDate = createdDate;
        this.projectCode = projectCode;
        this.projectType = projectType;
        this.projectBudget = projectBudget;
        this.costCentre = costCentre;
        this.branchNumber = branchNumber;
        this.allocationDate = allocationDate;
        this.finYear = finYear;
        this.fibreProjectManager = fibreProjectManager;
        this.state = state;
        this.requestor = requestor;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectType() {
        return this.projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Long getProjectBudget() {
        return this.projectBudget;
    }

    public void setProjectBudget(Long projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getCostCentre() {
        return this.costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getBranchNumber() {
        return this.branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public Date getAllocationDate() {
        return this.allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    public Date getFinYear() {
        return this.finYear;
    }

    public void setFinYear(Date finYear) {
        this.finYear = finYear;
    }

    public String getFibreProjectManager() {
        return this.fibreProjectManager;
    }

    public void setFibreProjectManager(String fibreProjectManager) {
        this.fibreProjectManager = fibreProjectManager;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRequestor() {
        return this.requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", projectCode='" + getProjectCode() + "'" +
            ", projectType='" + getProjectType() + "'" +
            ", projectBudget='" + getProjectBudget() + "'" +
            ", costCentre='" + getCostCentre() + "'" +
            ", branchNumber='" + getBranchNumber() + "'" +
            ", allocationDate='" + getAllocationDate() + "'" +
            ", finYear='" + getFinYear() + "'" +
            ", fibreProjectManager='" + getFibreProjectManager() + "'" +
            ", state='" + getState() + "'" +
            ", requestor='" + getRequestor() + "'" +
            "}";
    }
}    