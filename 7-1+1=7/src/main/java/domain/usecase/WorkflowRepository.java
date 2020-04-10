package domain.usecase;

import domain.model.Workflow;

import java.util.*;

public class WorkflowRepository {
    Map<String, Workflow> map = new HashMap<String, Workflow>();

    public String add(Workflow workflow) {
        String workflowId = "W"+Integer.toString(map.size()+1);
        map.put(workflowId, workflow);
        return workflowId;
    }
}
