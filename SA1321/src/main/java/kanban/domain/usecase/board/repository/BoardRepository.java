package kanban.domain.usecase.board.repository;

import kanban.domain.model.aggregate.board.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository implements IBoardRepository {

    private List<Board> boards;

    public BoardRepository() {
        boards = new ArrayList<Board>();
    }

    @Override
    public void add(Board board) {
        boards.add(board);
    }
}
