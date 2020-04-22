package domain.aggregate.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Workflow {
    private String boardId;
    private String workflowId;
    private String workflowName;
    private List<Stage> stageList;
    private List<Swimlane> swimlaneList;

    private Stage getStageById(String stageId) {
        for (Stage each : stageList) {
            if (each.getStageId().equalsIgnoreCase(stageId)) {
                return each;
            }
        }
        throw new RuntimeException("Stage is not found,id=" + stageId);
    }

    public Workflow(String workflowName) {
        stageList = new ArrayList<Stage>();
        swimlaneList = new ArrayList<Swimlane>();
        this.workflowId = UUID.randomUUID().toString();
        this.workflowName = workflowName;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setSwimlaneList(List<Swimlane> swimlaneList) {
        this.swimlaneList = swimlaneList;
    }

    public List<Swimlane> getSwimlaneList() {
        return swimlaneList;
    }

    public Swimlane createSwimlane(String swimlanName) {
        Swimlane swimlane = new Swimlane(workflowId, swimlanName);
        return swimlane;
    }

    public void addStage(Stage stage) {
        stageList.add(stage);
    }

    public Stage createStage(String stageName) {
        Stage stage = new Stage(workflowId,stageName);
        return stage;
    }

    public void addCardInStage(String stageId, String cardId) {
        Stage stage = getStageById(stageId);
        stage.addCardId(cardId);
    }

    public void addSwimlane(Swimlane swimlane) {
        swimlaneList.add(swimlane);
    }
}
