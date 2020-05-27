package ddd.kanban.usecase.board.get;

import ddd.kanban.usecase.board.BoardDTOMapper;
import ddd.kanban.usecase.board.BoardEntityMapper;
import ddd.kanban.usecase.board.dto.BoardDTO;
import ddd.kanban.usecase.repository.BoardRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllBoardsUseCase {
    private BoardRepository boardRepository;

    public GetAllBoardsUseCase(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }


    public void execute(GetAllBoardsInput getAllBoardsInput, GetAllBoardsOutput getAllBoardsOutput) {
        List<BoardDTO> boardDTOS = boardRepository.findAll().stream()
                                                            .map(BoardEntityMapper::mappingBoardFrom)
                                                            .map(BoardDTOMapper::mappingBoardDTOFrom)
                                                            .collect(Collectors.toList());
        getAllBoardsOutput.setBoards(boardDTOS);
    }

}
