package kanban.domain.usecase.workflow.repository;

import kanban.domain.model.aggregate.workflow.Workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkflowRepository implements IWorkflowRepository {

    private List<Workflow> workflows;

    public WorkflowRepository() {
        workflows = new ArrayList<Workflow>();
    }

    @Override
    public void add(Workflow workflow) {
        workflows.add(workflow);
    }

    @Override
    public Workflow getWorkflowById(String workflowId) {

        for (Workflow each : workflows) {
            if (each.getWorkflowId().equalsIgnoreCase(workflowId)) {
                return each;
            }
        }
        throw new RuntimeException("Workflow is not found,id=" + workflowId);
    }

    @Override
    public void save(Workflow workflow) {

        for (Workflow each : workflows) {
            if (each.getWorkflowId().equalsIgnoreCase(workflow.getWorkflowId())) {
                workflows.set(workflows.indexOf(each), workflow);
                break;
            }
        }
    }
}
