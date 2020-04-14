package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.UUID;

public class CreateCardOutput {
  private String cardId;
  private String cardName;

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  public String getCardName() {
    return this.cardName;
  }

  public void setCardId(UUID uuid) {
    this.cardId = uuid.toString();
  }

  public String getCardId() {
    return this.cardId;
  }
}