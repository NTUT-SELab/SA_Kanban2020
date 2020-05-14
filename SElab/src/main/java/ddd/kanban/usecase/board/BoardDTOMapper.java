package ddd.kanban.usecase.board;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.board.DTO.BoardDTO;

public class BoardDTOMapper {

    public BoardDTO mappingBoardDTOFrom(Board board){
        BoardDTO boardDTO = new BoardDTO(board.getId(), board.getTitle(), board.getDescription());
        boardDTO.setWorkflowIds(board.getWorkflowIds());
        return boardDTO;
    }
}
