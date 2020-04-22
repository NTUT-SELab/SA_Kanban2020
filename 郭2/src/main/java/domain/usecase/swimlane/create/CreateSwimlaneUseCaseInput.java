package domain.usecase.swimlane.create;

public class CreateSwimlaneUseCaseInput {
    private String workflowId;
    private String swimlaneName;

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
}
