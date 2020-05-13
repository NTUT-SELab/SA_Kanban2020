package ddd.kanban.spring.controller;


import ddd.kanban.usecase.DTO.BoardDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringBoardController {

    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO request) {
        return ResponseEntity.ok().body(request);
    }
}
