package domain.controller;

public class CreateWorkflowInputImpl implements CreateWorkflowInputInterface {
    private String workflowName;

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }
    public String getWorkflowName() {
        return this.workflowName;
    }
}
