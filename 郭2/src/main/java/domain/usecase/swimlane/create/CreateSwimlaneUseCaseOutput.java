package domain.usecase.swimlane.create;

public class CreateSwimlaneUseCaseOutput {
    private String workflowId;
    private String swimlaneName;
    private String swimlaneId;

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setSwimlaneName(String swimlaneName) {
        this.swimlaneName = swimlaneName;
    }

    public String getSwimlaneName() {
        return swimlaneName;
    }

    public void setSwimlaneId(String swimlaneId) {
        this.swimlaneId = swimlaneId;
    }

    public String getSwimlaneId() {
        return swimlaneId;
    }
}
