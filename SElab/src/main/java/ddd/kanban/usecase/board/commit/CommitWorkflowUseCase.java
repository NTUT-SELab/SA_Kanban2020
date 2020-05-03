package ddd.kanban.usecase.board.commit;

import ddd.kanban.domain.model.board.Board;
import ddd.kanban.usecase.repository.BoardRepository;

public class CommitWorkflowUseCase {
    private BoardRepository boardRepository;
    public CommitWorkflowUseCase(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void execute(CommitWorkflowInput commitWorkflowInput, CommitWorkflowOutput commitWorkflowOutput){
        Board board = boardRepository.findById(commitWorkflowInput.getBoardId());
        String workflowId = board.commitWorkflow(commitWorkflowInput.getWorkflowId());

        boardRepository.save();

        commitWorkflowOutput.setBoardId(board.getId());
        commitWorkflowOutput.setWorkflowId(workflowId);
    }

}
