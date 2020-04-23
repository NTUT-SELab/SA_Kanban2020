package domain.aggregate.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Stage {
    private String workflowId;
    private String stageId;
    private String stageName;
    private List<String> cardIds;

    public Stage(String workflowId,String stageName) {
        cardIds = new ArrayList<String>();
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;
        this.workflowId = workflowId;
    }

    public void setStageId(String stage_id) {
        this.stageId = stage_id;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void addCardId(String cardId) {
        cardIds.add(cardId);
    }


}
