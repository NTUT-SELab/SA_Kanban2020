package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import phd.sa.csie.ntut.edu.tw.domain.model.board.Board;
import phd.sa.csie.ntut.edu.tw.usecase.repository.BoardRepository;
import phd.sa.csie.ntut.edu.tw.usecase.board.column.create.*;

public class CreateColumnUseCaseTest {

  private BoardRepository boardRepository;
  private UUID boardUUID;

  @Before
  public void initialize() {
    boardRepository = new BoardRepository();
    Board board = new Board("phd");
    boardUUID = board.getUUID();
    boardRepository.add(board);
  }

  @Test
  public void createColumn() {
    CreateColumnUseCase createColumnUseCase = new CreateColumnUseCase(boardRepository);
    CreateColumnUseCaseInput createColumnUseCaseInput = new CreateColumnUseCaseInput();
    CreateColumnUseCaseOutput createColumnUseCaseOutput = new CreateColumnUseCaseOutput();
    createColumnUseCaseInput.setTitle("develop");
    createColumnUseCaseInput.setBoardId(boardUUID);
    createColumnUseCase.execute(createColumnUseCaseInput, createColumnUseCaseOutput);
    assertEquals("develop", createColumnUseCaseOutput.getTitle());
  }

}