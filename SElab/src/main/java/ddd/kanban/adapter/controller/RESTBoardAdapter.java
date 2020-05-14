package ddd.kanban.adapter.controller;

import ddd.kanban.adapter.DTO.BoardDTO;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;


public class RESTBoardAdapter {
    private BoardRepository boardRepository;
    private DomainEventBus domainEventBus;

    public RESTBoardAdapter(BoardRepository boardRepository, DomainEventBus domainEventBus){
        this.boardRepository = boardRepository;
        this.domainEventBus = domainEventBus;
    }

    public BoardDTO createBoard(BoardDTO requestBoardDTO) {
        String title = requestBoardDTO.getTitle();
        String description = requestBoardDTO.getDescription();

        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
        CreateBoardInput createBoardInput = new CreateBoardInput(title, description);
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);

        BoardDTO returnBoardDTO = new BoardDTO();
        returnBoardDTO.setId(createBoardOutput.getBoardId());
        returnBoardDTO.setTitle(createBoardOutput.getBoardTitle());
        returnBoardDTO.setDescription(createBoardOutput.getBoardDescription());
        return returnBoardDTO;
    }
}
