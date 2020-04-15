package domain.usecase;

import domain.entity.Workflow;
import java.util.*;

public class WorkflowRepository {
    private ArrayList<Workflow> workflowList = new ArrayList<Workflow>();

    public void add(Workflow workflow) {
        workflowList.add(workflow);
    }

    public Workflow getWorkflowById(String workflowId){
        for (Workflow each:workflowList) {
            if(workflowId.equals(each.getWorkflowId()))
                return each;
        }
        throw new RuntimeException("not found");
    }
}
