package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryCardRepository;
import ddd.kanban.domain.usecase.inputdata.CreateCardInput;
import ddd.kanban.domain.usecase.outputdata.CreateCardOutput;
import ddd.kanban.domain.usecase.repository.CardRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateCardUseCaseTest {
    private CardRepository cardRepository;

    @Before
    public void setUp(){
        cardRepository = new InMemoryCardRepository();
    }

    @Test
    public void testCreateCardUseCase(){
        String cardName = "TestCard";
        String cardDescriptino = "CardDescription";

        CreateCardUseCase createCardUseCase = new CreateCardUseCase(cardRepository);
        CreateCardInput createCardInput = new CreateCardInput(cardName, cardDescriptino);
        CreateCardOutput createCardOutput = new CreateCardOutput();

        createCardUseCase.execute(createCardInput, createCardOutput);

        assertEquals(cardName, createCardOutput.getCardName());
        assertEquals(cardDescriptino, createCardOutput.getCardDescription());

    }



}
