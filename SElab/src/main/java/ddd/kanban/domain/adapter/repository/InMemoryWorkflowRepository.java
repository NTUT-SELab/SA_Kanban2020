package ddd.kanban.domain.adapter.repository;

import ddd.kanban.domain.model.workflow.Workflow;
import ddd.kanban.domain.usecase.repository.WorkflowRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InMemoryWorkflowRepository implements WorkflowRepository {
    private List<Workflow> workflows;


    public InMemoryWorkflowRepository(){
        workflows = new ArrayList<Workflow>();
    }

    @Override
    public void add(Workflow workflow){
        workflows.add(workflow);
    }

    @Override
    public Optional<Workflow> findById(String workflowId){
        return workflows.stream()
                 .filter(findWorkflowById(workflowId))
                 .findFirst();
    }

    @Override
    public void save(Workflow workflow){
    }

    private static Predicate<Workflow> findWorkflowById(String workflowId){
        return workflow -> workflow.getId().equals(workflowId);
    }
}
