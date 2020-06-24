package ddd.kanban.usecase.card.commit;

public class CommitCardInput {
    private String cardId;
    private String workflowId;
    private String columnId;
    private String ColumnTitle;

    public CommitCardInput(String cardId, String workflowId, String columnId, String ColumnTitle) {
        this.cardId = cardId;
        this.workflowId = workflowId;
        this.columnId = columnId;
        this.ColumnTitle = ColumnTitle;
    }

    public String getCardId() {
        return cardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getColumnId() {
        return columnId;
    }

    public String getColumnTitle() {
        return ColumnTitle;
    }
}
