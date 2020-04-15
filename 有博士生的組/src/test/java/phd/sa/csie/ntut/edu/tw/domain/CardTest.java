package phd.sa.csie.ntut.edu.tw.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CardTest {

  @Test
  public void createCard() {
    Card card = new Card("create card");
    assertEquals("create card", card.getName());
    assertNotEquals("", card.getUUID().toString());
    assertNotNull(card.getUUID());
  }

}