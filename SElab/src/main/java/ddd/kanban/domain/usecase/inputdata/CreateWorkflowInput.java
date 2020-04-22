package ddd.kanban.domain.usecase.inputdata;

public class CreateWorkflowInput {

    private String workflowName;
    private String workflowId;

    public CreateWorkflowInput(String workflowId,String workflowName){
        this.workflowName = workflowName;
        this.workflowId = workflowId;
    }

    public String getWorkflowName() {return workflowName;}

    public String getWorkflowId() { return workflowId; }
}
