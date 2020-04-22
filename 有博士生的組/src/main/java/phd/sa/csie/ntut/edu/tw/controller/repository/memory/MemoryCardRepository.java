package phd.sa.csie.ntut.edu.tw.controller.repository.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.usecase.repository.CardRepository;
import phd.sa.csie.ntut.edu.tw.domain.model.card.Card;

public class MemoryCardRepository implements CardRepository{

  private Map<UUID, Card> map;

  public MemoryCardRepository() {
    this.map = new HashMap<>();
  }

  public void add(Card card) {
    map.put(card.getUUID(), card);
  }

  public Card findCardByUUID(UUID uuid) {
    return map.get(uuid);
  }

}