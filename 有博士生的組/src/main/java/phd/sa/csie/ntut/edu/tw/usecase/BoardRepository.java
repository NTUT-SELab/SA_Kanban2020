package phd.sa.csie.ntut.edu.tw.usecase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import phd.sa.csie.ntut.edu.tw.domain.Board;

public class BoardRepository {

  private Map<UUID, Board> boards;

  public BoardRepository() {
    this.boards = new HashMap<>();
  }

  public void add(Board board) {
    this.boards.put(board.getUUID(), board);
  }

  Board findBoardByUUID(UUID uuid) {
    return this.boards.get(uuid);
  }

}