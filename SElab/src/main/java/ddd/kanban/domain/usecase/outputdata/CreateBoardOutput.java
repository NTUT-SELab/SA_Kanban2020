package ddd.kanban.domain.usecase.outputdata;

public class CreateBoardOutput {
    private String boardId;
    private String boardName;

    public CreateBoardOutput(){

    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
