package ddd.kanban.domain.usecase.repository;



import ddd.kanban.domain.model.Board.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    void add(Board board);

    Optional<Board> findById(String boardId);

    void save();

    List<Board> findAll();
}
