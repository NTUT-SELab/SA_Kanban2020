package domain.usecase;

import domain.controller.CreateStageInputImpl;
import domain.controller.CreateStageInputInterface;
import domain.controller.CreateStageOutputImpl;
import domain.controller.CreateStageOutputInterface;
import domain.entity.StageRepository;
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

        StageRepository stageRepository = StageRepository.getInstance();

        assertNotNull(stageRepository.get(createStageOutput.getStageId()));
    }
}
