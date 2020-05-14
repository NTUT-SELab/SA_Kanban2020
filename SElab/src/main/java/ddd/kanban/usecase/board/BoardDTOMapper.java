package ddd.kanban.usecase.board;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.board.DTO.BoardEntity;

public class BoardDTOMapper {

    public BoardEntity mappingBoardDTOFrom(Board board){
        BoardEntity boardEntity = new BoardEntity(board.getId(), board.getTitle(), board.getDescription());
        boardEntity.setWorkflowIds(board.getWorkflowIds());
        return boardEntity;
    }
}
