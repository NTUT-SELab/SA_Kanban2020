package kanban.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Workflow {

    private String id;

    private List<Stage> stages;

    public Workflow(String id){
        this.id = id;
        stages = new ArrayList<Stage>();
    }

    public String createStage(String stageName) {
        Stage stage = new Stage(
                UUID.randomUUID().toString(),
                stageName);

        stages.add(stage);

        return stage.getId();
    }

    public String getId() {
        return id;
    }
}
