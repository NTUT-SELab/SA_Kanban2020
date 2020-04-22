package domain.adapter;

import domain.entity.Board;
import domain.usecase.board.BoardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BoardRepositoryImpl implements BoardRepository {
    private Map<String, Board> boardRepository ;
    private Connection conn;

    public BoardRepositoryImpl(){
        boardRepository = new HashMap<String, Board>() ;

    }


    public Board getBoardById(String id){
        return this.boardRepository.get(id) ;
    }

    public void save(Board board){
        try {
            this.boardRepository.put(board.getId(), board);
            this.conn = DatabaseImpl.getConnection();
            add(board.getId(), board.getName());
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void add(String boardId, String boardName){

        String sql = "INSERT INTO kanban.board(id, name) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,boardId);
            ps.setString(2,boardName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
