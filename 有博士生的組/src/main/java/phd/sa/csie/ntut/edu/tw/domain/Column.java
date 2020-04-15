package phd.sa.csie.ntut.edu.tw.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Column {

  private String title;
  private ArrayList<UUID> cardIds;

  public Column(String title) {
    this.title = title;
    this.cardIds = new ArrayList<>();
  }

  public String getTitle() {
    return this.title;
  }

  public void addCard(UUID uuid) {
    cardIds.add(uuid);
  }

  public void removeCard(UUID uuid) {
    cardIds.remove(uuid);
  }

}