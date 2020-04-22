package domain.usecase.workflow.create;

import domain.aggregate.board.Board;
import domain.aggregate.workflow.Workflow;
import domain.usecase.board.repository.IBoardRepository;
import domain.usecase.workflow.repository.IWorkflowRepository;

public class CreateWorkflowUseCase {
    private IWorkflowRepository workflowRepository;
    private IBoardRepository boardRepository;

    public CreateWorkflowUseCase(IWorkflowRepository workflowRepository, IBoardRepository boardRepository) {
        this.workflowRepository = workflowRepository;
        this.boardRepository = boardRepository;
    }

    public void execute(CreateWorkflowUseCaseInput input, CreateWorkflowUseCaseOutput output) {
        Board board = boardRepository.getBoardById(input.getBoardId());
        Workflow workflow = new Workflow(input.getWorkflowName());

        workflowRepository.add(workflow);
        board.addWorkflowId(workflow.getWorkflowId());
        boardRepository.save(board);

        output.setWorkflowId(workflow.getWorkflowId());
        output.setWorkflowName(workflow.getWorkflowName());
    }
}
