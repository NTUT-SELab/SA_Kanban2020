package kanban.domain.model.aggregate.board;

import java.util.UUID;

public class Board {

    private String boardName;
    private String boardId;

    public Board(String boardName) {
        this.boardName = boardName;
        this.boardId = UUID.randomUUID().toString();
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardId() {
        return boardId;
    }

}
