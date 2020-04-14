package ddd.kanban.domain.usecase;

import ddd.kanban.domain.entity.Workflow;

public class WorkflowRepository {
    private Workflow workflow;


    public WorkflowRepository(){
    }

    public Workflow findById(String workflowId){
        workflow = new Workflow();
        return workflow;
    }
}
