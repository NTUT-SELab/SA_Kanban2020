package phd.sa.csie.ntut.edu.tw.domain;

import java.util.UUID;

public class Card {

  private String name;
  private UUID uuid;

  public Card(String name) {
    this.name = name;
    this.uuid = UUID.randomUUID();
  }

  public String getName() {
    return this.name;
  }

  public UUID getUUID() {
    return this.uuid;
  }
}