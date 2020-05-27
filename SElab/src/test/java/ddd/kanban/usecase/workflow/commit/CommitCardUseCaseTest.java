package ddd.kanban.usecase.workflow.commit;

import ddd.kanban.adapter.repository.workflow.InMemoryWorkflowRepository;
import ddd.kanban.usecase.repository.WorkflowRepository;
import org.junit.Before;
import org.junit.Test;

public class CommitCardUseCaseTest {

    private WorkflowRepository workflowRepository;

    @Before
    public void setUp(){
        workflowRepository = new InMemoryWorkflowRepository();
    }

    @Test
    public void testCommitCard(){
        CommitCardUseCase commitCardUseCase = new CommitCardUseCase(workflowRepository);
        //TODO
    }
}
