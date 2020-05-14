package ddd.kanban.adapter.controller;

import ddd.kanban.adapter.DTO.BoardDTO;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.usecase.board.create.CreateBoardInput;
import ddd.kanban.usecase.board.create.CreateBoardOutput;
import ddd.kanban.usecase.board.create.CreateBoardUseCase;
import ddd.kanban.usecase.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class RESTBoardAdapter {
    private BoardRepository boardRepository;
    private DomainEventBus domainEventBus;

    @Autowired
    public RESTBoardAdapter(BoardRepository boardRepository, DomainEventBus domainEventBus){
        this.boardRepository = boardRepository;
        this.domainEventBus = domainEventBus;
    }

    @RestController
    @RequestMapping(value = "/board", produces = MediaType.APPLICATION_JSON_VALUE)
    public class SpringBoardController {

        @PostMapping
        public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO createBoardInputBody) {

            CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(boardRepository, domainEventBus);
            CreateBoardInput createBoardInput = new CreateBoardInput(createBoardInputBody.getTitle(), createBoardInputBody.getDescription());
            CreateBoardOutput createBoardOutput = new CreateBoardOutput();

            createBoardUseCase.execute(createBoardInput, createBoardOutput);

            BoardDTO boardDTO = new BoardDTO();

            return ResponseEntity.ok().body(boardDTO);
        }
    }
}
