package kanban.domain.usecase;


import kanban.domain.usecase.board.repository.BoardRepository;
import kanban.domain.usecase.board.create.CreateBoardInput;
import kanban.domain.usecase.board.create.CreateBoardOutput;
import kanban.domain.usecase.board.create.CreateBoardUseCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateBoardTest {

    private BoardRepository boardRepository;

    @Before
    public void setUp(){
        boardRepository = new BoardRepository();
    }

    @Test
    public void Create_board_should_success(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);
        CreateBoardInput input = new CreateBoardInput();
        CreateBoardOutput output = new CreateBoardOutput();

        input.setBoardName("Board");
        createBoardUseCase.execute(input, output);
        assertNotNull(output.getBoardId());
        assertEquals("Board", output.getBoardName());
    }


}
