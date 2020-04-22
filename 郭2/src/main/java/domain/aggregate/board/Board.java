package domain.aggregate.board;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
    private List<String> workflowIds;
    private String boardId;
    private String boardName;

    public Board(String boardName){
        workflowIds = new ArrayList<String>();
        this.boardId = UUID.randomUUID().toString();
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardId() {
        return boardId;
    }

    public void addWorkflowId(String workflowId) {
        workflowIds.add(workflowId);
    }
}
