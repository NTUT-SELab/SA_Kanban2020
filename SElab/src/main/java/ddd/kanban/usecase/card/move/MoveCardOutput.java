package ddd.kanban.usecase.card.move;

public class MoveCardOutput {
    private String toColumnId;
    private String cardId;

    public String getToLaneId() {
        return toColumnId;
    }

    public void setToLaneId(String toLaneId) {
        this.toColumnId = toLaneId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
