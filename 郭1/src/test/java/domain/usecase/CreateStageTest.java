package domain.usecase;

import domain.controller.CreateStageInputImpl;
import domain.controller.CreateStageInputInterface;
import domain.controller.CreateStageOutputImpl;
import domain.controller.CreateStageOutputInterface;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateStageTest {
    @Test
    public void createStage() {
        CreateStageUseCase createStage = new CreateStageUseCase() ;
        CreateStageInputInterface createStageInput = new CreateStageInputImpl() ;
        CreateStageOutputInterface createStageOutput = new CreateStageOutputImpl() ;

        createStageInput.setStageName("stage1");
        createStage.execute( createStageInput, createStageOutput ) ;
        assertNotNull(createStageOutput.getStageId());
    }
}
