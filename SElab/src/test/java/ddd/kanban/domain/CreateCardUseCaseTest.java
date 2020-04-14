package ddd.kanban.domain;

import ddd.kanban.domain.usecase.CreateCardInput;
import ddd.kanban.domain.usecase.CreateCardOutput;
import ddd.kanban.domain.usecase.CreateCardUseCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CreateCardUseCaseTest {
    @Test
    public void testCreateCard() {
        String cardName = "createdCardTest";
        CreateCardUseCase createCardUseCase = new CreateCardUseCase();
        CreateCardInput createCardInput = new CreateCardInput(cardName);
        CreateCardOutput createCardOutput = new CreateCardOutput();
        createCardUseCase.execute(createCardInput, createCardOutput);
        assertEquals(createCardOutput.getCardName(), cardName);
    }
}
