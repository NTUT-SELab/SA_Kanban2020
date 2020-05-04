package ddd.kanban.usecase;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.DTO.BoardDTO;

public class DTOMapper {

    public BoardDTO mappingFrom(Board board){
        return new BoardDTO(board.getId(), board.getName(), board.getDescription(), board.getWorkflowIds());
    }
}
