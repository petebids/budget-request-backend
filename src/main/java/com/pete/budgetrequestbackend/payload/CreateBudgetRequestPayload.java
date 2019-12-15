package com.pete.budgetrequestbackend.payload;

import javax.validation.constraints.NotNull;

public class CreateBudgetRequestPayload {

    @NotNull
    private String branchNumber;

    @NotNull
    private String costCentre;

    @NotNull
    private String fibreProjectManager;

    @NotNull
    private Long projectBudget;

    @NotNull
    private String projectCode;

    @NotNull
    private String projectType;

    @NotNull
    private String requestor;

    @NotNull
    private String state;

    public CreateBudgetRequestPayload() {
    }

    public CreateBudgetRequestPayload(String branchNumber, String costCentre, String fibreProjectManager, Long projectBudget, String projectCode, String projectType, String requestor, String state) {
        this.branchNumber = branchNumber;
        this.costCentre = costCentre;
        this.fibreProjectManager = fibreProjectManager;
        this.projectBudget = projectBudget;
        this.projectCode = projectCode;
        this.projectType = projectType;
        this.requestor = requestor;
        this.state = state;
    }

    public String getBranchNumber() {
        return this.branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getCostCentre() {
        return this.costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getFibreProjectManager() {
        return this.fibreProjectManager;
    }

    public void setFibreProjectManager(String fibreProjectManager) {
        this.fibreProjectManager = fibreProjectManager;
    }

    public Long getProjectBudget() {
        return this.projectBudget;
    }

    public void setProjectBudget(Long projectBudget) {
        this.projectBudget = projectBudget;
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

    public String getRequestor() {
        return this.requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CreateBudgetRequestPayload branchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
        return this;
    }

    public CreateBudgetRequestPayload costCentre(String costCentre) {
        this.costCentre = costCentre;
        return this;
    }

    public CreateBudgetRequestPayload fibreProjectManager(String fibreProjectManager) {
        this.fibreProjectManager = fibreProjectManager;
        return this;
    }

    public CreateBudgetRequestPayload projectBudget(Long projectBudget) {
        this.projectBudget = projectBudget;
        return this;
    }

    public CreateBudgetRequestPayload projectCode(String projectCode) {
        this.projectCode = projectCode;
        return this;
    }

    public CreateBudgetRequestPayload projectType(String projectType) {
        this.projectType = projectType;
        return this;
    }

    public CreateBudgetRequestPayload requestor(String requestor) {
        this.requestor = requestor;
        return this;
    }

    public CreateBudgetRequestPayload state(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " branchNumber='" + getBranchNumber() + "'" +
            ", costCentre='" + getCostCentre() + "'" +
            ", fibreProjectManager='" + getFibreProjectManager() + "'" +
            ", projectBudget='" + getProjectBudget() + "'" +
            ", projectCode='" + getProjectCode() + "'" +
            ", projectType='" + getProjectType() + "'" +
            ", requestor='" + getRequestor() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }

}