package ddd.kanban.domain.usecase;

import ddd.kanban.domain.entity.Column;
import ddd.kanban.domain.entity.Workflow;

import java.util.Optional;

public class CreateColumnUseCase {
    private WorkflowRepository workflowRepository = new WorkflowRepository();

    public CreateColumnUseCase(){

    }

    public void execute(CreateColumnInput createColumnInput, CreateColumnOutput createColumnOutput) {
        Workflow workflow = workflowRepository.findById(createColumnInput.getWorkflowId());
        workflow.createColumn(createColumnInput.getColumnName());

        Optional<Column> column = workflow.findColumnById("001");
        column.ifPresent(c -> {
            createColumnOutput.setColumnId(c.getColumnId());
        });
    }
}
