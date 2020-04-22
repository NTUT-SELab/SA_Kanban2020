package phd.sa.csie.ntut.edu.tw.domain.model.board;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

public class Board {

  private UUID Id;
  private String name;
  private ArrayList<Column> columns;

  public Board(String name) {
    this.Id = UUID.randomUUID();
    this.name = name;
    this.columns = new ArrayList<>();
  }

  public UUID getUUID() {
    return this.Id;
  }

  public String getName() {
    return this.name;
  }

  public String createColumn(String columnTitle) {
    Column column = new Column(columnTitle);
    this.columns.add(column);
    return column.getTitle();
  }

  public void addCardToColumn(UUID cardId, String columnTitle) {
    Column column = this.getColumnByTitle(columnTitle);
    column.addCard(cardId);
  }

  public void setColumnWIP(String columnTitle, int wip) {
    if(wip < 0) {
      throw new IllegalArgumentException( "WIP should not be negative");
    }
    Column column = this.getColumnByTitle(columnTitle);
    column.setWIP(wip);
  }

  public String moveCard(UUID cardId, String fromColumnTitle, String toColumnTitle) {
    Column from = this.getColumnByTitle(fromColumnTitle);
    Column to = this.getColumnByTitle(toColumnTitle);
    from.removeCard(cardId);
    to.addCard(cardId);
    return to.getTitle();
  }

  private Column getColumnByTitle(String title) {
    for (Column column : columns) {
      if(column.getTitle().equals(title)) {
        return column;
      }
    }
    throw new RuntimeException("Column Not Found");
  }

}
