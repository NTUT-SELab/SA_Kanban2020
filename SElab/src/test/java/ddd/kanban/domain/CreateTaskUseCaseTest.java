package ddd.kanban.domain;

import ddd.kanban.domain.usecase.CreateTaskInput;
import ddd.kanban.domain.usecase.CreateTaskOutput;
import ddd.kanban.domain.usecase.CreateTaskUseCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CreateTaskUseCaseTest {


    @Test
    public void testCreateTask(){
        CreateTaskInput createTaskInput = new CreateTaskInput("001", "asdf");
        CreateTaskOutput createTaskOutput = new CreateTaskOutput();
        CreateTaskUseCase createTaskUseCase = new CreateTaskUseCase();

        createTaskUseCase.execute(createTaskInput, createTaskOutput);

        assertEquals(createTaskOutput.getTaskName(), "asdf");

    }

}
