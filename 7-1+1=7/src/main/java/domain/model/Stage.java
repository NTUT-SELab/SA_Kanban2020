package domain.model;

import java.util.UUID;

public class Stage {
    private String stageName;
    private String stageId;

    public Stage(String stageName) {
        this.stageName = stageName;
        stageId = "S" + UUID.randomUUID().toString();
    }

    public String getStageId() {
        return stageId;
    }
}
