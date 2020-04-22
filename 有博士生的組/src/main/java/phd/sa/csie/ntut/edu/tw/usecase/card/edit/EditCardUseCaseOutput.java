package phd.sa.csie.ntut.edu.tw.usecase.card.edit;

public class EditCardUseCaseOutput {
  private String cardId;
  private String cardName;

  public void setCardId(String id) {
    this.cardId = id;
  }

  public String getCardId() {
    return this.cardId;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  public String getCardName() {
    return this.cardName;
  }
}