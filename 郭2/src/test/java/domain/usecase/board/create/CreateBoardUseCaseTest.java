package domain.usecase.board.create;

import domain.adapter.repository.board.InMemoryBoardRepository;
import domain.usecase.board.repository.IBoardRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateBoardUseCaseTest {
    @Test
    public void createBoardTest(){
        IBoardRepository boardRepository = new InMemoryBoardRepository();
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);
        CreateBoardUseCaseInput input = new CreateBoardUseCaseInput();
        CreateBoardUseCaseOutput output = new CreateBoardUseCaseOutput();

        input.setBoardName("Kanban of KanbanDevelopment");

        createBoardUseCase.execute(input, output);

        assertEquals("Kanban of KanbanDevelopment", output.getBoardName());
        assertNotNull(output.getBoardId());
    }
}
