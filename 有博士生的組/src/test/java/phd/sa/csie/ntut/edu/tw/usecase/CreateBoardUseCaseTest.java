package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import phd.sa.csie.ntut.edu.tw.usecase.repository.BoardRepository;
import phd.sa.csie.ntut.edu.tw.usecase.board.create.*;

public class CreateBoardUseCaseTest {
  BoardRepository boardRepository;

  @Before
  public void init() {
    boardRepository = new BoardRepository();
  }

  @Test
  public void createBoard() {
    CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);
    CreateBoardUseCaseInput createBoardUseCaseInput = new CreateBoardUseCaseInput();
    CreateBoardUseCaseOutput createBoardUseCaseOutput = new CreateBoardUseCaseOutput();
    createBoardUseCaseInput.setTitle("Software Architecture");
    createBoardUseCase.execute(createBoardUseCaseInput, createBoardUseCaseOutput);
    assertNotNull(createBoardUseCaseOutput.getBoardId());
    assertEquals("Software Architecture", createBoardUseCaseOutput.getBoardTitle());
  }

}