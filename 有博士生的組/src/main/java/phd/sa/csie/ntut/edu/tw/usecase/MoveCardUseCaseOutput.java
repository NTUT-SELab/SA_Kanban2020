package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.UUID;

public class MoveCardUseCaseOutput {

  private String cardId;
  private String oldColumnTitle;
  private String newColumnTitle;

  public void setCardId(UUID cardId) {
    this.cardId = cardId.toString();
  }

  public String getCardId() {
    return this.cardId;
  }

  public void setOldColumnTitle(String title) {
    this.oldColumnTitle = title;
  }

  public String getOldColumnTitle() {
    return this.oldColumnTitle;
  }

  public void setNewColumnTitle(String title) {
    this.newColumnTitle = title;
  }

  public String getNewColumnTitle() {
    return this.newColumnTitle;
  }
}