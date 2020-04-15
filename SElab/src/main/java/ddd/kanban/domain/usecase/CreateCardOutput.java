package ddd.kanban.domain.usecase;

public class CreateCardOutput {
    private String cardName;
    private String cardId;

    public CreateCardOutput(){}

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


}
