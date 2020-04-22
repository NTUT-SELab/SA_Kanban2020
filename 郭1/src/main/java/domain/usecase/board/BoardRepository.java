package domain.usecase.board;

import domain.entity.Board;

import java.sql.SQLException;

public interface BoardRepository {

    Board getBoardById(String id);

    void save(Board board);
}
