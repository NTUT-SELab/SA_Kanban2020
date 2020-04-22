package phd.sa.csie.ntut.edu.tw.domain.model.board;

import java.util.ArrayList;
import java.util.UUID;

public class Column {

  private String title;
  private int wip;
  private ArrayList<UUID> cardIds;

  public Column(String title) {
    this.title = title;
    this.wip = 0;
    this.cardIds = new ArrayList<>();
  }

  public String getTitle() {
    return this.title;
  }

  public void setWIP(int wip) {
    this.wip = wip;
  }

  public int getWIP() {
    return this.wip;
  }

  public void addCard(UUID uuid) {
    cardIds.add(uuid);
  }

  public void removeCard(UUID uuid) {
    cardIds.remove(uuid);
  }

}