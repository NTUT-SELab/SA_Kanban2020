package ddd.kanban.usecase;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.DTO.BoardDTO;

public class EntityMapper {
    public Board mappingBoardEntityFrom(BoardDTO boardDTO){
        Board board = new Board(boardDTO.getId(), boardDTO.getName(), boardDTO.getDescription());
        board.setWorkflowIds(boardDTO.getWorkflowIds());
        return  board;
    }
}
