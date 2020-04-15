package domain.usecase;

import domain.entity.Card;
import domain.entity.Workflow;

public class CreateCardUseCase {
    private CardRepository cardRepository;

    public CreateCardUseCase(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    public void execute(CreateCardUseCaseInput createCardUseCaseInput, CreateCardUseCaseOutput createCardUseCaseOutput) {
        Card card = new Card(createCardUseCaseInput.getCardName(), createCardUseCaseInput.getStageId());
        cardRepository.add(card);
        createCardUseCaseOutput.setStageId(card.getStageId());
        createCardUseCaseOutput.setCardName(card.getCardName());
        createCardUseCaseOutput.setCardId(card.getCardId());
    }
}
