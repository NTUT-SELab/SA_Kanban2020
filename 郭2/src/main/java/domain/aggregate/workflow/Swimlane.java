package domain.aggregate.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Swimlane {
    private String workflowId;
    private String swimlaneId;
    private String swimlaneName;
    private List<String> cardIds;

    public Swimlane(String workflowId,String swimlaneName) {
        cardIds = new ArrayList<String>();
        this.swimlaneId = UUID.randomUUID().toString();
        this.swimlaneName = swimlaneName;
        this.workflowId = workflowId;
    }

    public String getSwimlaneName() {
        return swimlaneName;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getSwimlaneId() {
        return swimlaneId;
    }

    public List<String> getCardIds() {
        return cardIds;
    }
}
