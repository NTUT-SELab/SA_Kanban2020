package domain.controller;

import domain.usecase.board.create.CreateBoardOutput;

public class CreateBoardOutputImpl implements CreateBoardOutput {
    private String boardId;

    public String getBoardId() {
        return boardId;
    }


    public void setBoardId(String boardId){
        this.boardId = boardId;
    }
}
