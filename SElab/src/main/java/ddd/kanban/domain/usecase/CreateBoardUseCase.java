package ddd.kanban.domain.usecase;


import ddd.kanban.domain.model.Board.Board;
import ddd.kanban.domain.usecase.inputdata.CreateBoardInput;
import ddd.kanban.domain.usecase.outputdata.CreateBoardOutput;
import ddd.kanban.domain.usecase.repository.BoardRepository;


import java.util.UUID;

public class CreateBoardUseCase {

    private BoardRepository boardRepository;

    public CreateBoardUseCase(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }


    public void execute(CreateBoardInput createBoardInput, CreateBoardOutput createBoardOutput) {
        Board board = new Board(UUID.randomUUID().toString(), createBoardInput.getBoardName());
        boardRepository.add(board);
        boardRepository.save();

        createBoardOutput.setBoardId(board.getId());
        createBoardOutput.setBoardName(board.getName());
    }
}
