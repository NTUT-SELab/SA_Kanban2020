//package ddd.kanban.application.controller;
//import ddd.kanban.adapter.DTO.BoardDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
//public class SpringBoardController {
//
//    @Autowired
//    public SpringBoardController() {
//
//        System.out.println("123");
//    }
//    @PostMapping
//    public ResponseEntity<String> createBoard(@RequestBody BoardDTO request) {
//        return ResponseEntity.ok().body("output");
//    }
//}
