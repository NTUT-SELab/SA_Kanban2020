package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryCardRepository;
import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.usecase.inputdata.EditCardUseCaseInput;
import ddd.kanban.domain.usecase.outputdata.EditCardUseCaseOutput;
import ddd.kanban.domain.usecase.repository.CardRepository;
import org.junit.*;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class EditCardUseCaseTest {
    private InMemoryCardRepository cardRepository;

    @Before
    public void setUp(){
        cardRepository = new InMemoryCardRepository();
    }

    @Test
    public void testEditCardUseCase() {
        String newCardName = "cardNewName";
        String newCardDescription = "cardNewDescription";

        Card card = new Card(UUID.randomUUID().toString(), "cardName", "cardDescription");
        cardRepository.add(card);

        EditCardUseCase editCardUseCase = new EditCardUseCase(cardRepository);
        EditCardUseCaseInput editCardUseCaseInput = new EditCardUseCaseInput("workflow001", card.getId(), newCardName, newCardDescription);
        EditCardUseCaseOutput editCardUseCaseOutput = new EditCardUseCaseOutput();

        editCardUseCase.execute(editCardUseCaseInput, editCardUseCaseOutput);

        assertEquals(newCardName, editCardUseCaseOutput.getCardName());
        assertEquals(newCardDescription, editCardUseCaseOutput.getCardDescription());
    }

}
