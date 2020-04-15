package phd.sa.csie.ntut.edu.tw.usecase;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import phd.sa.csie.ntut.edu.tw.domain.Board;
import phd.sa.csie.ntut.edu.tw.domain.Card;

public class MoveCardUseCaseTest {

  private CardRepository cardRepository;
  private BoardRepository boardRepository;
  private CreateCardUseCase createCardUseCase;
  private CreateColumnUseCase createColumnUseCase;
  private Card card;
  private String fromColumnTitle;
  private String toColumnTitle;
  private UUID boardId;

  @Before
  public void initialize() {
    cardRepository = new CardRepository();
    boardRepository = new BoardRepository();
    createCardUseCase = new CreateCardUseCase(cardRepository);
    createColumnUseCase = new CreateColumnUseCase(boardRepository);

    Board board = new Board("phd");
    boardId = board.getUUID();
    boardRepository.add(board);

    CreateCardUseCaseInput createCardUseCaseInput = new CreateCardUseCaseInput();
    CreateCardUseCaseOutput createCardUseCaseOutput = new CreateCardUseCaseOutput();
    createCardUseCaseInput.setCardName("test card");
    createCardUseCase.execute(createCardUseCaseInput, createCardUseCaseOutput);
    card = cardRepository.findCardByUUID(UUID.fromString(createCardUseCaseOutput.getCardId()));

    CreateColumnUseCaseInput createColumnUseCaseInput = new CreateColumnUseCaseInput();
    CreateColumnUseCaseOutput createColumnUseCaseOutput = new CreateColumnUseCaseOutput();
    createColumnUseCaseInput.setBoardId(boardId);
    createColumnUseCaseInput.setTitle("develop column");
    createColumnUseCase.execute(createColumnUseCaseInput, createColumnUseCaseOutput);
    fromColumnTitle = createColumnUseCaseOutput.getTitle();
    createColumnUseCaseInput.setBoardId(boardId);
    createColumnUseCaseInput.setTitle("test column");
    createColumnUseCase.execute(createColumnUseCaseInput, createColumnUseCaseOutput);
    toColumnTitle = createColumnUseCaseOutput.getTitle();

    board.addCardToColumn(card.getUUID(), fromColumnTitle);
  }

  @Test
  public void moveCard() {
    MoveCardUseCase moveCardUseCase = new MoveCardUseCase(boardRepository);
    MoveCardUseCaseInput moveCardUseCaseInput = new MoveCardUseCaseInput();
    MoveCardUseCaseOutput moveCardUseCaseOutput = new MoveCardUseCaseOutput();
    moveCardUseCaseInput.setBoardId(boardId);
    moveCardUseCaseInput.setCardId(card.getUUID());
    moveCardUseCaseInput.setFromColumnTitle(fromColumnTitle);
    moveCardUseCaseInput.setToColumnTitle(toColumnTitle);
    moveCardUseCase.execute(moveCardUseCaseInput, moveCardUseCaseOutput);
    assertEquals(card.getUUID().toString(), moveCardUseCaseOutput.getCardId());
    assertEquals(fromColumnTitle, moveCardUseCaseOutput.getOldColumnTitle());
    assertEquals(toColumnTitle, moveCardUseCaseOutput.getNewColumnTitle());
  }

}