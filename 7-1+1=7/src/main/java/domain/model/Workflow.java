package domain.model;

public class Workflow {
    private String workflowName;
    private String boardId;

    public Workflow(String workflowName, String boardId) {
        this.workflowName = workflowName;
        this.boardId = boardId;
    }
}
