package ddd.kanban.usecase.card.commit;

public class CommitCardInput {
    private String cardId;
    private String workflowId;
    private String laneId;

    public CommitCardInput(String cardId, String workflowId, String laneId) {
        this.cardId = cardId;
        this.workflowId = workflowId;
        this.laneId = laneId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getLaneId() {
        return laneId;
    }
}
