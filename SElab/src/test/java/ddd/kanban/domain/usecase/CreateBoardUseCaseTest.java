package ddd.kanban.domain.usecase;

import ddd.kanban.domain.adapter.repository.InMemoryBoardRepository;
import ddd.kanban.domain.adapter.repository.SqliteBoardRepository;
import ddd.kanban.domain.model.Board.Board;
import ddd.kanban.domain.usecase.inputdata.CreateBoardInput;
import ddd.kanban.domain.usecase.outputdata.CreateBoardOutput;
import ddd.kanban.domain.usecase.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;

import static org.junit.Assert.assertEquals;

public class CreateBoardUseCaseTest {
    private BoardRepository inMemoryBoardRepository;
    private BoardRepository sqliteBoardRepository;

    @Before
    public void setUp(){
        inMemoryBoardRepository = new InMemoryBoardRepository();
        sqliteBoardRepository = new SqliteBoardRepository();
    }

    @Test
    public void testCreateBoardUseCase(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(inMemoryBoardRepository);
        CreateBoardInput createBoardInput = new CreateBoardInput("TestBoard");
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);
        assertEquals("TestBoard", createBoardOutput.getBoardName());
    }

    @Test
    public void testCreateBoardUseCaseWithSQLite(){
        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(sqliteBoardRepository);
        CreateBoardInput createBoardInput = new CreateBoardInput("TestBoard1");
        CreateBoardOutput createBoardOutput = new CreateBoardOutput();
        createBoardUseCase.execute(createBoardInput, createBoardOutput);
        assertEquals("TestBoard1", createBoardOutput.getBoardName());
    }
}
