package phd.sa.csie.ntut.edu.tw.domain;

import java.util.ArrayList;
import java.util.UUID;

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

  public void addCardToColumn(Card card, String columnTitle) {
    
  }

}
