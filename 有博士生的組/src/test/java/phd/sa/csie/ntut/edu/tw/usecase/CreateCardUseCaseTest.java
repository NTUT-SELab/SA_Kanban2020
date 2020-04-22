package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import phd.sa.csie.ntut.edu.tw.usecase.repository.CardRepository;
import phd.sa.csie.ntut.edu.tw.usecase.card.create.*;

public class CreateCardUseCaseTest {

  private CardRepository cardRepository;

  @Before
  public void initialize() {
    cardRepository = new CardRepository();
  }

  @Test
  public void createCard() {
    CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository);
    CreateCardUseCaseInput createCardUseCaseInput = new CreateCardUseCaseInput();
    CreateCardUseCaseOutput createCardUseCaseOutput = new CreateCardUseCaseOutput();
    createCardUseCaseInput.setCardName("Create Card");
    createCardUseCase.execute(createCardUseCaseInput, createCardUseCaseOutput);
    assertEquals("Create Card", createCardUseCaseOutput.getCardName());
    assertNotEquals("", createCardUseCaseOutput.getCardId());
    assertNotNull(createCardUseCaseOutput.getCardId());
  }

}