package domain.entity;

import java.util.UUID;

public class Stage {
    private String workflowId;
    private String stageId;
    private String stageName;

    public Stage(String workflowId,String stageName) {
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;
        this.workflowId = workflowId;
    }

    public String getStageId() {
        return stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public String getWorkflowId() {
        return workflowId;
    }
}
