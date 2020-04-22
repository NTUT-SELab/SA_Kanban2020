package domain.usecase.board.create;

public class CreateBoardUseCaseOutput {
    private String boardId;
    private String boardName;

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }
}

