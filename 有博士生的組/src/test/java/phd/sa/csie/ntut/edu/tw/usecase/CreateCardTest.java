package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CreateCardTest {

  private CardRepository cardRepository;

  @Before
  public void initialize() {
    cardRepository = new CardRepository();
  }

  @Test
  public void createCard() {
    CreateCard createCard = new CreateCard(cardRepository);
    CreateCardInput createCardInput = new CreateCardInput();
    CreateCardOutput createCardOutput = new CreateCardOutput();
    createCardInput.setCardName("Create Card");
    createCard.execute(createCardInput, createCardOutput);
    assertEquals("Create Card", createCardOutput.getCardName());
    assertNotEquals("", createCardOutput.getCardId());
    assertNotNull(createCardOutput.getCardId());
  }

}