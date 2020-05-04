package ddd.kanban.usecase.board.commit;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.DTO.BoardDTO;
import ddd.kanban.usecase.EntityMapper;
import ddd.kanban.usecase.repository.BoardRepository;

public class CommitWorkflowUseCase {
    private BoardRepository boardRepository;
    private EntityMapper entityMapper;
    public CommitWorkflowUseCase(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
        this.entityMapper = new EntityMapper();
    }

    public void execute(CommitWorkflowInput commitWorkflowInput, CommitWorkflowOutput commitWorkflowOutput){
        BoardDTO boardDTO = boardRepository.findById(commitWorkflowInput.getBoardId());
        Board board = entityMapper.mappingBoardEntityFrom(boardDTO);
        String workflowId = board.commitWorkflow(commitWorkflowInput.getWorkflowId());

        boardRepository.save();

        commitWorkflowOutput.setBoardId(board.getId());
        commitWorkflowOutput.setWorkflowId(workflowId);
    }

}
