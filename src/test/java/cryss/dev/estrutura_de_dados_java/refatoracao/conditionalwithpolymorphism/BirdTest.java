package cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism;

import cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution.Bird;
import cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution.European;
import cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution.SAFFRON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class BirdTest {



    @Test
    void returnErrorWhenInvalidBuildBird(){

        BirdClassWitthConditionalType bird = BirdClassWitthConditionalType
                .builder ().build ();

        assertThrows (RuntimeException.class, ()-> bird.getSpeed ());

    }

    @Test
    void returnSpeedOfWhenValidBird(){

        BirdClassWitthConditionalType bird = BirdClassWitthConditionalType
                .builder ()
                .type (BirdType.SAFFRON)
                .name ("Safron")
                .build ();

        assertEquals (bird.getSpeed (), 110F);

    }

    @Test
    void returnSpeedOfWhenValidBirdWithState(){

        Bird birdSAFFRON = SAFFRON
                .builder ()
                .name ("Safron")
                .build ();

        Bird birdEuropean = European
                .builder ()
                .name ("European")
                .build ();

        assertEquals (birdSAFFRON.getSpeed (), 110F);
        assertEquals (birdEuropean.getSpeed (), 100F);

    }

}