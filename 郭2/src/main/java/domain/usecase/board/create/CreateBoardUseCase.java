package domain.usecase.board.create;

import domain.aggregate.board.Board;
import domain.adapter.repository.board.InMemoryBoardRepository;
import domain.usecase.board.repository.IBoardRepository;

public class CreateBoardUseCase {
    private IBoardRepository boardRepository;
    private Board board;

    public CreateBoardUseCase(IBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void execute(CreateBoardUseCaseInput input, CreateBoardUseCaseOutput output) {
        board = new Board(input.getBoardName());
        boardRepository.add(board);
        output.setBoardId(board.getBoardId());
        output.setBoardName(board.getBoardName());
    }
}
