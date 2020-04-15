package phd.sa.csie.ntut.edu.tw.usecase;

import phd.sa.csie.ntut.edu.tw.domain.Card;

public class CreateCardUseCase {

  private CardRepository cardRepository;

  public CreateCardUseCase(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  public void execute(CreateCardUseCaseInput createCardInput, CreateCardUseCaseOutput createCardOutput) {
    String cardName = createCardInput.getCardName();
    Card card = new Card(cardName);
    cardRepository.add(card);
    createCardOutput.setCardName(card.getName());
    createCardOutput.setCardId(card.getUUID());
  }

}