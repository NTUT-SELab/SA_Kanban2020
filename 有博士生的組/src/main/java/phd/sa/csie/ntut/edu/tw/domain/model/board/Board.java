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

  public UUID createColumn(String columnTitle) {
    Column column = new Column(columnTitle);
    this.columns.add(column);
    return column.getId();
  }

  public void addCardToColumn(UUID cardId, UUID columnId) {
    Column column = this.getColumnById(columnId);
    column.addCard(cardId);
  }

  public void setColumnWIP(UUID columnId, int wip) {
    if(wip < 0) {
      throw new IllegalArgumentException( "WIP should not be negative");
    }
    Column column = this.getColumnById(columnId);
    column.setWIP(wip);
  }

  public String moveCard(UUID cardId, UUID fromColumnId, UUID toColumnId) {
    Column from = this.getColumnById(fromColumnId);
    Column to = this.getColumnById(toColumnId);
    from.removeCard(cardId);
    to.addCard(cardId);
    return to.getTitle();
  }

  private Column getColumnById(UUID id) {
    for (Column column : columns) {
      if(column.getId().equals(id)) {
        return column;
      }
    }
    throw new RuntimeException("Column Not Found");
  }

}
