package ddd.kanban.domain;

import ddd.kanban.domain.usecase.CreateColumnInput;
import ddd.kanban.domain.usecase.CreateColumnOutput;
import ddd.kanban.domain.usecase.CreateColumnUseCase;
import ddd.kanban.domain.usecase.GetColumnUseCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CreateColumnUseCaseTest {


    @Test
    public void testCreateColumn(){
        CreateColumnUseCase createColumnUseCase = new CreateColumnUseCase();
        CreateColumnInput createColumnInput = new CreateColumnInput("asdf", "001");
        CreateColumnOutput createColumnOutput = new CreateColumnOutput();

        createColumnUseCase.execute(createColumnInput, createColumnOutput);

        assertEquals(createColumnOutput.getColumnId(), "001");
    }
}
