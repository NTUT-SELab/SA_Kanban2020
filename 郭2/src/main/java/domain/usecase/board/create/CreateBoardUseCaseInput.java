package domain.usecase.board.create;

public class CreateBoardUseCaseInput {
    private String boardName;

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }
}
