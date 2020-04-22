package phd.sa.csie.ntut.edu.tw.usecase.board.column.setwip;

import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.domain.model.board.Board;
import phd.sa.csie.ntut.edu.tw.usecase.repository.BoardRepository;

public class SetColumnWIPUseCase {

  private BoardRepository boardRepository;

  public SetColumnWIPUseCase(BoardRepository repository) {
    this.boardRepository = repository;
  }

  public void execute(SetColumnWIPUseCaseInput input, SetColumnWIPUseCaseOutput output) {
    UUID boardId = input.getBoardId();
    String columnTitle = input.getColumnTitle();
    int wip = input.getColumnWIP();
    Board board = boardRepository.findBoardByUUID(boardId);
    board.setColumnWIP(columnTitle, wip);
    boardRepository.add(board);
    output.setColumnTitle(columnTitle);
    output.setColumnWIP(wip);
  }

}