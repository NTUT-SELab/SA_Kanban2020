package phd.sa.csie.ntut.edu.tw.usecase.board.column.setwip;

public class SetColumnWIPUseCaseOutput {

  private String columnTitle;
  private int columnWIP;

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