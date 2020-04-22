package ddd.kanban.domain.usecase;

import ddd.kanban.domain.model.workflow.Column;
import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.domain.usecase.inputdata.CreateColumnInput;
import ddd.kanban.domain.usecase.outputdata.CreateColumnOutput;
import ddd.kanban.domain.usecase.repository.WorkflowRepository;

import java.util.Optional;

public class CreateColumnUseCase {
    private WorkflowRepository workflowRepository;

    public CreateColumnUseCase(WorkflowRepository workflowRepository){
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateColumnInput createColumnInput, CreateColumnOutput createColumnOutput) {
        Optional<Workflow> workflow = workflowRepository.findById(createColumnInput.getWorkflowId());
        workflow.ifPresent(w -> {
            String columnName = w.createColumn(createColumnInput.getColumnName(), createColumnInput.getWorkflowId());
            createColumnOutput.setColumnName(columnName);
            workflowRepository.save(w);
        });
    }
}
