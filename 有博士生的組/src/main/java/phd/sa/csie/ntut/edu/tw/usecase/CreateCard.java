package phd.sa.csie.ntut.edu.tw.usecase;

import phd.sa.csie.ntut.edu.tw.domain.Card;

public class CreateCard {

  private CardRepository cardRepository;

  public CreateCard(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  public void execute(CreateCardInput createCardInput, CreateCardOutput createCardOutput) {
    String cardName = createCardInput.getCardName();
    Card card = new Card(cardName);
    cardRepository.add(card);
    createCardOutput.setCardName(card.getName());
    createCardOutput.setCardId(card.getUUID());
  }

}