package domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Workflow {
    private String workflowId;
    private String workflowName;
    private List<Stage> stages;
    public Workflow(String workflowName) {
        stages = new ArrayList<Stage>();
        this.workflowId = UUID.randomUUID().toString();
        this.workflowName = workflowName;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }
}
