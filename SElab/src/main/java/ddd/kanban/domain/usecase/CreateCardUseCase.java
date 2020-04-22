package ddd.kanban.domain.usecase;

import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.usecase.outputdata.CreateCardOutput;
import ddd.kanban.domain.usecase.inputdata.CreateCardInput;
import ddd.kanban.domain.usecase.repository.CardRepository;

import java.util.UUID;

public class CreateCardUseCase {
    private CardRepository cardRepository;

    public CreateCardUseCase(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }


    public void execute(CreateCardInput createCardInput, CreateCardOutput createCardOutput) {
        Card card = new Card(UUID.randomUUID().toString(), createCardInput.getCardName(), createCardInput.getCardDescription());
        cardRepository.add(card);
        cardRepository.save(card);

        createCardOutput.setCardId(card.getId());
        createCardOutput.setCardName(card.getName());
        createCardOutput.setCardDescription(card.getDescription());
    }
}
