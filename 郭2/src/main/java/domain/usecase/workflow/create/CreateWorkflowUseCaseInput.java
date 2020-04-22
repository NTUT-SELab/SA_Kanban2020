package domain.usecase.workflow.create;

public class CreateWorkflowUseCaseInput {
    private String boardId;
    private String workflowName;

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }
}
