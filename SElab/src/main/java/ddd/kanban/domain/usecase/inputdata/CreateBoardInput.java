package ddd.kanban.domain.usecase.inputdata;

public class CreateBoardInput {

    private String boardName;

    public CreateBoardInput(String boardName){
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }
}
