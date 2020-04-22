package phd.sa.csie.ntut.edu.tw.usecase.board.column.setwip;

import java.util.UUID;

public class SetColumnWIPUseCaseInput {

  private String columnTitle;
  private int columnWIP;
  private UUID boardId;

  public void setBoardId(UUID id) {
    this.boardId = id;
  }

  public UUID getBoardId() {
    return this.boardId;
  }

  public void setColumnTitle(String title) {
    this.columnTitle = title;
  }

  public String getColumnTitle() {
    return this.columnTitle;
  }

  public void setColumnWIP(int wip) {
    this.columnWIP = wip;
  }

  public int getColumnWIP() {
    return this.columnWIP;
  }

}