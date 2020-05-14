package ddd.kanban.application.controller;

import ddd.kanban.adapter.DTO.BoardDTO;
import ddd.kanban.adapter.controller.RESTBoardAdapter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringBoardController {

    private RESTBoardAdapter RESTBoardAdapter;

    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO request) {
        BoardDTO output = RESTBoardAdapter.createBoard(request);
        return ResponseEntity.ok().body(output);
    }
}
