package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.domain.Card;

public class CardRepository {

  private Map<UUID, Card> map;

  public CardRepository() {
    this.map = new HashMap<>();
  }

  public void add(Card card) {
    map.put(card.getUUID(), card);
  }

  Card findCardByUUID(UUID uuid) {
    return map.get(uuid);
  }

}