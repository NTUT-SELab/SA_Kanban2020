package domain.usecase.swimlane.create;

import domain.aggregate.workflow.Swimlane;
import domain.aggregate.workflow.Workflow;
import domain.usecase.workflow.repository.IWorkflowRepository;

public class CreateSwimlaneUseCase {
    private IWorkflowRepository workflowRepository;
    public CreateSwimlaneUseCase(IWorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void execute(CreateSwimlaneUseCaseInput input, CreateSwimlaneUseCaseOutput output) {
        Workflow workflow = workflowRepository.getWorkflowById(input.getWorkflowId());
        Swimlane swimlane = workflow.createSwimlane(input.getSwimlaneName());

        workflow.addSwimlane(swimlane);
        workflowRepository.save(workflow);

        output.setWorkflowId(swimlane.getWorkflowId());
        output.setSwimlaneName(swimlane.getSwimlaneName());
        output.setSwimlaneId(swimlane.getSwimlaneId());
    }
}
