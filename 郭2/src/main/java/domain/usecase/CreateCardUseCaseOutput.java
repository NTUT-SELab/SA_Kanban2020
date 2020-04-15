package domain.usecase;

public class CreateCardUseCaseOutput {
    private String stageId;
    private String cardName;
    private String cardId;

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

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

    public String getStageId() {
        return stageId;
    }
}
