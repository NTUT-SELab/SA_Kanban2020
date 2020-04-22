package kanban.domain.adapter.repository.board;

import kanban.domain.model.aggregate.board.Board;
import kanban.domain.usecase.board.repository.IBoardRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBoardRepository implements IBoardRepository {

    private List<Board> boards;

    public InMemoryBoardRepository() {
        boards = new ArrayList<Board>();
    }

    @Override
    public void add(Board board) {
        boards.add(board);
    }

    @Override
    public Board getBoardById(String boardId) {
        for (Board each : boards) {
            if (each.getBoardId().equalsIgnoreCase(boardId)) {
                return each;
            }
        }
        throw new RuntimeException("Board is not found,id=" + boardId);
    }

    @Override
    public void save(Board board) {
        for (Board each : boards) {
            if (each.getBoardId().equalsIgnoreCase(board.getBoardId())) {
                boards.set(boards.indexOf(each), board);
                break;
            }
        }
    }
}
