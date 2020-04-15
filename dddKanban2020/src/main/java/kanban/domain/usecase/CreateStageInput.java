package kanban.domain.usecase;

public class CreateStageInput {
    private String stageName;
    private String workflowId;

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }


    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }

}
