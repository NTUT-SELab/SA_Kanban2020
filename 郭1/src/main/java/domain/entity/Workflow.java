package domain.entity;

import java.util.*;


public class Workflow {
    private String name;
    private String id;
    private HashMap<String,Stage> stages;
    public Workflow(){
        this.stages = new HashMap<String, Stage>();
        this.id = UUID.randomUUID().toString();
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void addStage(Stage stage){
        this.stages.put(stage.getId(),stage);
    }


    public String createStage(String stageName) {
        Stage stage = new Stage();
        stage.setName(stageName);
        this.addStage(stage);

        return stage.getId();
    }

    public String createSwimlane(String stageId, String swimlaneName){
        Swimlane swimlane = new Swimlane();
        swimlane.setName(swimlaneName);

        stages.get(stageId).addSwimlane(swimlane);

        return swimlane.getId();
    }

    public String getName() {
        return this.name;
    }
    public HashMap<String,Stage> getStageMap(){
        return this.stages;
    }
}
