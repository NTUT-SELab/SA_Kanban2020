package domain.usecase;


import domain.controller.CreateBoardInputImpl;
import domain.controller.CreateBoardOutputImpl;
import domain.adapter.BoardRepositoryImpl;
import domain.usecase.board.BoardRepository;
import domain.usecase.board.create.CreateBoardInput;
import domain.usecase.board.create.CreateBoardOutput;
import domain.usecase.board.create.CreateBoardUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateBoardTest {
    @Test
    public void createBoard(){

        BoardRepository boardRepository = new BoardRepositoryImpl();


        CreateBoardInput createBoardInput = new CreateBoardInputImpl();
        CreateBoardOutput createBoardOutput = new CreateBoardOutputImpl();
        createBoardInput.setName("board1");
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);

        createBoardUseCase.execute(createBoardInput,createBoardOutput);

        assertNotNull(createBoardOutput.getBoardId());

    }
}
