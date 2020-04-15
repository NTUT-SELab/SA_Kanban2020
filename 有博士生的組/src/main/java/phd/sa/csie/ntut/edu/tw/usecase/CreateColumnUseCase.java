package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.domain.Board;

public class CreateColumnUseCase {

  private BoardRepository boardRepository;

  public CreateColumnUseCase(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public void execute(CreateColumnUseCaseInput createColumnUseCaseInput,
                      CreateColumnUseCaseOutput createColumnUseCaseOutput) {
    String title = createColumnUseCaseInput.getTitle();
    UUID boardId = createColumnUseCaseInput.getBoardId();
    Board board = this.boardRepository.findBoardByUUID(boardId);
    String columnTitle = board.createColumn(title);
    createColumnUseCaseOutput.setTitle(columnTitle);
  }

}