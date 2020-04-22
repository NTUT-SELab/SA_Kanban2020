package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.UUID;

public class MoveCardUseCaseInput {

  private UUID boardId;
  private UUID cardId;
  private String fromColumnTitle;
  private String toColumnTitle;

  public void setBoardId(UUID boardId) {
    this.boardId = boardId;
  }

  public UUID getBoardId() {
    return this.boardId;
  }

  public void setCardId(UUID cardId) {
    this.cardId = cardId;
  }

  public UUID getCardId() {
    return this.cardId;
  }

  public void setFromColumnTitle(String title) {
    this.fromColumnTitle = title;
  }

  public String getFromColumnTitle() {
    return this.fromColumnTitle;
  }

  public void setToColumnTitle(String title) {
    this.toColumnTitle = title;
  }

  public String getToColumnTitle() {
    return this.toColumnTitle;
  }

}