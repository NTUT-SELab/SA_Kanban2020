package ddd.kanban.adapter.repository.board;

import ddd.kanban.adapter.database.DataBaseUtility;
import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.DTO.BoardDTO;
import ddd.kanban.usecase.repository.BoardRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SqliteBoardRepository implements BoardRepository {

    private DataBaseUtility dataBaseUtility;

    private List<BoardDTO> boards;

    public SqliteBoardRepository(){
        dataBaseUtility = new DataBaseUtility();
        boards = new ArrayList<>();
        boards.addAll(findAllBoardFromDatabase());
    }

    @Override
    public void add(BoardDTO boardDTO) {
        if (isExist(boardDTO))
            throw new RuntimeException("Board exist");
        boards.add(boardDTO);
    }

    private boolean isExist(BoardDTO boardDTO) {
        return boards.stream()
                .map(BoardDTO::getId)
                .anyMatch(id -> boardDTO.getId().equals(id));
    }

    @Override
    public BoardDTO findById(String boardId) {
        return boards.stream()
                .filter(board -> board.getId().equals(boardId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private static Predicate<Board> findBoardById(String boardId){
        return board -> board.getId().equals(boardId);
    }

    @Override
    public List<BoardDTO> findAll() {
        return boards;
    }

    @Override
    public void save() {
        boards.forEach(this::saveToDatabase);
    }

    private void saveToDatabase(BoardDTO boardDTO){
        Connection connection = dataBaseUtility.getConnection();
        String saveCommand = String.format("INSERT INTO Board (id, name, description) VALUES (?, ?, ?)" +
                "ON CONFLICT(id) DO UPDATE SET name = ?");

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(saveCommand);
            preparedStatement.setString(1, boardDTO.getId());
            preparedStatement.setString(2, boardDTO.getTitle());
            preparedStatement.setString(3, boardDTO.getDescription());
            preparedStatement.setString(4, boardDTO.getTitle());
            boolean resultInformation = preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            dataBaseUtility.rollBack(connection);
        } finally {
            dataBaseUtility.close(connection);
        }
    }

    private List<BoardDTO> findAllBoardFromDatabase(){
        //TODO : How to get workflowIds
        //      by execute SQL command 2 times?
        Connection connection = dataBaseUtility.getConnection();
        String queryCommand = String.format("SELECT * FROM Board");
        List<BoardDTO> resultBoards = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryCommand);

            while (resultSet.next()){
                BoardDTO boardDTO = new BoardDTO(resultSet.getString("id"), resultSet.getString("name"),resultSet.getString("description"));
                resultBoards.add(boardDTO);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
           dataBaseUtility.close(connection);
        }
        return resultBoards;
    }
}
