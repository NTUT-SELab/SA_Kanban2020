package ddd.kanban.usecase.workflow.create;

public class CreateWorkflowInput {

    private String workflowTitle;
    private String workflowId;
    private  String workflowBoardId;

    public CreateWorkflowInput(String workflowId, String workflowTitle, String workflowBoardId){
        this.workflowId = workflowId;
        this.workflowTitle = workflowTitle;
        this.workflowBoardId = workflowBoardId;
    }

    public String getWorkflowId() { return workflowId; }

    public String getWorkflowTitle() {return workflowTitle;}

    public  String getWorkflowBoardId(){return  workflowBoardId; }
}
