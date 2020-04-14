package kanban.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Stage {
    private String workflowId;
    private String stageId;
    private String name;
    private List<String> cardIds;

    public Stage(String workflowId, String stageName) {
        this.workflowId = workflowId;
        stageId = UUID.randomUUID().toString();
        name = stageName;
        cardIds = new ArrayList<String>();
    }

    public String getStageId() {
        return stageId;
    }

    public String getStageName() {
        return name;
    }

    public List<String> getCardIds() {
        return cardIds;
    }

    public void setCardIds(List<String> cardIds) {
        this.cardIds = cardIds;
    }

    public String commitCard(String cardId) {
        cardIds.add(cardId);
        return cardId;
    }
}
