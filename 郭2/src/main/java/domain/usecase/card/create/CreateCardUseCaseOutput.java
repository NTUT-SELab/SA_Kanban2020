package domain.usecase.card.create;

public class CreateCardUseCaseOutput {
    private String cardName;
    private String cardId;

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardId() {
        return cardId;
    }

}
