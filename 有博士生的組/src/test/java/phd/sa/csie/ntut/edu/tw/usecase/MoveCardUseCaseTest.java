package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import phd.sa.csie.ntut.edu.tw.domain.Board;

public class MoveCardUseCaseTest {

  private CardRepository cardRepository;
  private BoardRepository boardRepository;
  private CreateCardUseCase createCardUseCase;
  private CreateColumnUseCase createColumnUseCase;

  @Before
  public void initialize() {
    cardRepository = new CardRepository();
    boardRepository = new BoardRepository();
    createCardUseCase = new CreateCardUseCase(cardRepository);
    createColumnUseCase = new CreateColumnUseCase(boardRepository);

    Board board = new Board("phd");
    UUID boardUUID = board.getUUID();
    boardRepository.add(board);

    CreateCardUseCaseInput createCardUseCaseInput = new CreateCardUseCaseInput();
    CreateCardUseCaseOutput createCardUseCaseOutput = new CreateCardUseCaseOutput();
    createCardUseCaseInput.setCardName("test card");
    createCardUseCase.execute(createCardUseCaseInput, createCardUseCaseOutput);

    CreateColumnUseCaseInput createColumnUseCaseInput = new CreateColumnUseCaseInput();
    CreateColumnUseCaseOutput createColumnUseCaseOutput = new CreateColumnUseCaseOutput();
    createColumnUseCaseInput.setBoardId(boardUUID);
    createColumnUseCaseInput.setTitle("develop column");
    createColumnUseCase.execute(createColumnUseCaseInput, createColumnUseCaseOutput);
    createColumnUseCaseInput.setBoardId(boardUUID);
    createColumnUseCaseInput.setTitle("test column");
    createColumnUseCase.execute(createColumnUseCaseInput, createColumnUseCaseOutput);
  }

  @Test
  public void moveCard() {


  }

}