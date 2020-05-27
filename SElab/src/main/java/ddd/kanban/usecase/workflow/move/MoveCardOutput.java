package ddd.kanban.usecase.workflow.move;

public class MoveCardOutput {
    private String workflowId;
    private String fromLaneId;
    private String toLaneId;
    private String cardId;

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getFromLaneId() {
        return fromLaneId;
    }

    public void setFromLaneId(String fromLaneId) {
        this.fromLaneId = fromLaneId;
    }

    public String getToLaneId() {
        return toLaneId;
    }

    public void setToLaneId(String toLaneId) {
        this.toLaneId = toLaneId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
