package ddd.kanban.domain.usecase;

import ddd.kanban.domain.entity.Card;

public class CreateCardUseCase {
    private final CardRepository cardRepository;

    public CreateCardUseCase(){
        cardRepository = new CardRepository();
    }

    public void execute(CreateCardInput createCardInput, CreateCardOutput createCardOutput){
        Card card = new Card("001", createCardInput.getCardName());
        createCardOutput.setCardId(card.getId());
        createCardOutput.setCardName(card.getName());
        cardRepository.save(card);
    }
}
