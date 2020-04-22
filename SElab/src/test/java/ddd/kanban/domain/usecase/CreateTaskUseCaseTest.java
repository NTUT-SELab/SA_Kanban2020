package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryCardRepository;
import ddd.kanban.domain.model.card.Card;
import ddd.kanban.domain.usecase.inputdata.CreateTaskInput;
import ddd.kanban.domain.usecase.outputdata.CreateTaskOutput;
import ddd.kanban.domain.usecase.repository.CardRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CreateTaskUseCaseTest {
    private CardRepository inMemoryCardRepository;
    private String cardId;

    @Before
    public void setUp(){
        inMemoryCardRepository = new InMemoryCardRepository();
        cardId = UUID.randomUUID().toString();
        Card card = new Card(cardId, "TestCard", "CardDescription");
        inMemoryCardRepository.add(card);
    }

    @Test
    public void testCreateTask(){
        CreateTaskInput createTaskInput = new CreateTaskInput(cardId, "Task_test");
        CreateTaskOutput createTaskOutput = new CreateTaskOutput();
        CreateTaskUseCase createTaskUseCase = new CreateTaskUseCase(inMemoryCardRepository);

        createTaskUseCase.execute(createTaskInput, createTaskOutput);

        assertEquals("Task_test", createTaskOutput.getTaskName());

    }

}
