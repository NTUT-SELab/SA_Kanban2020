package ddd.kanban.usecase;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;

public class Create {
    private BoardRepository boardRepository;
    public Create(){
        boardRepository = new InMemoryBoardRepository();
    }


    public String CreateBoard(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository);
    }
}
