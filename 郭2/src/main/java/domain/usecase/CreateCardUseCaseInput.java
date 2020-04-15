package domain.usecase;

public class CreateCardUseCaseInput {
    private String cardName;
    private String stageId;
    private String workflowId;


    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getStageId() {
        return stageId;
    }
}
