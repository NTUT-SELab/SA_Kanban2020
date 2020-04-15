package domain.controller;

import domain.usecase.CreateWorkflowInputInterface;

public class CreateWorkflowInputImpl implements CreateWorkflowInputInterface {
    private String workflowName;

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }
    public String getWorkflowName() {
        return this.workflowName;
    }
}
