package ddd.kanban.usecase.card.commit;

public class CommitCardInput {
    private String cardId;
    private String workflowId;
    private String laneId;
    private String ColumnTitle;

    public CommitCardInput(String cardId, String workflowId, String laneId, String ColumnTitle) {
        this.cardId = cardId;
        this.workflowId = workflowId;
        this.laneId = laneId;
        this.ColumnTitle = ColumnTitle;
    }

    public String getCardId() {
        return cardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getColumnId() {
        return laneId;
    }

    public String getColumnTitle() {
        return ColumnTitle;
    }
}
