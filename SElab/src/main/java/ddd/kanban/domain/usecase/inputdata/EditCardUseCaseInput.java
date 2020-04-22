package ddd.kanban.domain.usecase.inputdata;

public class EditCardUseCaseInput {
    private String workflowId;
    private String cardId;
    private String cardName;
    private String cardDescription;

    public EditCardUseCaseInput(String workflowId, String cardId, String cardName, String cardDescription) {
        this.workflowId = workflowId;
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }
}
