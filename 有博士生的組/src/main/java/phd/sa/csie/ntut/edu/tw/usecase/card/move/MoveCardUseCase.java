package phd.sa.csie.ntut.edu.tw.usecase.card.move;

import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.domain.model.board.Board;
import phd.sa.csie.ntut.edu.tw.usecase.repository.BoardRepository;

public class MoveCardUseCase {

  private BoardRepository boardRepository;

  public MoveCardUseCase(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public void execute(MoveCardUseCaseInput moveCardUseCaseInput,
                      MoveCardUseCaseOutput moveCardUseCaseOutput) {
    Board board = boardRepository.findBoardByUUID(moveCardUseCaseInput.getBoardId());
    UUID cardId = moveCardUseCaseInput.getCardId();
    String fromColumnTitle = moveCardUseCaseInput.getFromColumnTitle();
    String toColumnTitle = moveCardUseCaseInput.getToColumnTitle();
    String newColumnTitle = board.moveCard(cardId, fromColumnTitle, toColumnTitle);
    moveCardUseCaseOutput.setCardId(cardId);
    moveCardUseCaseOutput.setOldColumnTitle(fromColumnTitle);
    moveCardUseCaseOutput.setNewColumnTitle(newColumnTitle);
  }

}