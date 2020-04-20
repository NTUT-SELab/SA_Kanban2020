package kanban.domain.usecase.board.create;

import kanban.domain.model.aggregate.board.Board;
import kanban.domain.usecase.board.repository.BoardRepository;

public class CreateBoardUseCase {
    private BoardRepository boardRepository;

    public CreateBoardUseCase(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void execute(CreateBoardInput input, CreateBoardOutput output) {
        Board board = new Board(input.getBoardName());
        boardRepository.add(board);
        output.setBoardId(board.getBoardId());
        output.setBoardName(board.getBoardName());
    }
}
