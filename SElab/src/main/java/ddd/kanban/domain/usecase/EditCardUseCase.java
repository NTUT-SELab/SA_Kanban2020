package ddd.kanban.domain.usecase;

import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.usecase.inputdata.EditCardUseCaseInput;
import ddd.kanban.domain.usecase.outputdata.EditCardUseCaseOutput;
import ddd.kanban.domain.usecase.repository.CardRepository;

import java.util.Optional;

public class EditCardUseCase {
    private CardRepository cardRepository;

    public EditCardUseCase(CardRepository cardRepository) { this.cardRepository = cardRepository; }

    public void execute(EditCardUseCaseInput editCardUseCaseInput, EditCardUseCaseOutput editCardUseCaseOutput) {
        Optional<Card> card = cardRepository.findById( editCardUseCaseInput.getCardId() );
        card.ifPresent(c -> {
            c.setName(editCardUseCaseInput.getCardName());
            c.setDescription(editCardUseCaseInput.getCardDescription());
            cardRepository.update(c);
            cardRepository.save(c);

            editCardUseCaseOutput.setCardId(c.getId());
            editCardUseCaseOutput.setCardName(c.getName());
            editCardUseCaseOutput.setCardDescription(c.getDescription());
        });
    }
}
