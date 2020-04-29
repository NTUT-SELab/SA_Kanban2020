package ddd.kanban.usecase.card.create;

import ddd.kanban.domain.model.card.Card;
import ddd.kanban.usecase.repository.CardRepository;

import java.util.UUID;

public class CreateCardUseCase {
    private CardRepository cardRepository;

    public CreateCardUseCase(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }


    public void execute(CreateCardInput createCardInput, CreateCardOutput createCardOutput) {
        Card card = new Card(UUID.randomUUID().toString(), createCardInput.getCardTitle(), createCardInput.getBoardId(), createCardInput.getWorkflowId());

        cardRepository.add(card);

        createCardOutput.setCardId(card.getId());
        createCardOutput.setCardTitle(card.getTitle());
    }
}
