package kanban.domain.usecase;

import kanban.domain.model.Workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkflowRepository {

    private List<Workflow> workflows;

    public WorkflowRepository(){
        workflows = new ArrayList<Workflow>();
    }

    public Workflow findById(String workflowId) {

        for(Workflow each : workflows){
            if(each.getId().equalsIgnoreCase(workflowId)){
                return each;
            }
        }

        throw  new RuntimeException("Workflow not found, id = " + workflowId);
    }

    public void add(Workflow workflow) {
        workflows.add(workflow);
    }
}
