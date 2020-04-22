package kanban.domain.usecase.workflow.create;

import kanban.domain.model.aggregate.workflow.Workflow;
import kanban.domain.usecase.board.repository.IBoardRepository;
import kanban.domain.usecase.workflow.commit.CommitWorkflowInput;
import kanban.domain.usecase.workflow.commit.CommitWorkflowOutput;
import kanban.domain.usecase.workflow.commit.CommitWorkflowUseCase;
import kanban.domain.usecase.workflow.repository.IWorkflowRepository;

public class CreateWorkflowUseCase {

    private IBoardRepository boardRepository;
    private IWorkflowRepository workflowRepository;

    public CreateWorkflowUseCase(IBoardRepository boardRepository, IWorkflowRepository workflowRepository){
        this.workflowRepository= workflowRepository;
        this.boardRepository = boardRepository;
    }

    public void execute(CreateWorkflowInput input, CreateWorkflowOutput output) {

        Workflow workflow= new Workflow(input.getWorkflowName());
        workflowRepository.add(workflow);
        output.setWorkflowName(workflow.getName());
        output.setWorkflowId(workflow.getWorkflowId());

        CommitWorkflowUseCase commitWorkflowUseCase = new CommitWorkflowUseCase(boardRepository);
        CommitWorkflowInput commitWorkflowInput = new CommitWorkflowInput();
        CommitWorkflowOutput commitWorkflowOutput = new CommitWorkflowOutput();

        commitWorkflowInput.setBoardId(input.getBoardId());
        commitWorkflowInput.setWorkflowId("workflowId");

        commitWorkflowUseCase.execute(commitWorkflowInput, commitWorkflowOutput);
    }
}
