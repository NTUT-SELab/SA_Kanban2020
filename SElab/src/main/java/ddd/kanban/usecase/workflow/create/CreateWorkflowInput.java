package ddd.kanban.usecase.workflow.create;

public class CreateWorkflowInput {

    private String workflowTitle;
    private String workflowId;

    public CreateWorkflowInput(String workflowId,String workflowTitle){
        this.workflowTitle = workflowTitle;
        this.workflowId = workflowId;
    }

    public String getWorkflowTitle() {return workflowTitle;}

    public String getWorkflowId() { return workflowId; }
}
