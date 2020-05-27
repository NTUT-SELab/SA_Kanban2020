package ddd.kanban.usecase.workflow.create;

import ddd.kanban.adapter.repository.board.InMemoryBoardRepository;
import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.domain.model.DomainEventBus;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.usecase.HierarchyInitial;
import ddd.kanban.usecase.repository.BoardRepository;
import ddd.kanban.usecase.workflow.mapper.WorkflowEntityMapper;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateWorkflowUseCaseTest {
    private WorkflowRepository workflowRepository;
    private BoardRepository boardRepository;
    private HierarchyInitial hierarchyInitial;
    private String boardId;
    private DomainEventBus domainEventBus;

    @Before
    public void setUp(){
        workflowRepository = new InMemoryWorkflowRepository();
        boardRepository = new InMemoryBoardRepository();
        this.domainEventBus = new DomainEventBus();
        hierarchyInitial = new HierarchyInitial(boardRepository, workflowRepository, domainEventBus);
        this.boardId = hierarchyInitial.CreateBoard();

    }

    @Test
    public void testCreateWorkflow() {
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository, domainEventBus);

        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInput("Workflow 1", boardId);
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutput();

        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);

        assertEquals("Workflow 1", createWorkflowOutput.getWorkflowTitle());
        assertNotNull(createWorkflowOutput.getWorkflowId());
    }

    @Test
    public void testCreateWorkflowShouldCreateDefaultColumn(){
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository, domainEventBus);

        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInput("Workflow 1", boardId);
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutput();

        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);

        assertEquals("Workflow 1", createWorkflowOutput.getWorkflowTitle());
        assertNotNull(createWorkflowOutput.getWorkflowId());
        assertNotNull(createWorkflowOutput.getDefaultColumnId());

        Workflow workflow = WorkflowEntityMapper.mappingWorkflowFrom(workflowRepository.findById(createWorkflowOutput.getWorkflowId()));
        assertEquals("Default Column", workflow.findColumnById(createWorkflowOutput.getDefaultColumnId()).getTitle());
    }
}
