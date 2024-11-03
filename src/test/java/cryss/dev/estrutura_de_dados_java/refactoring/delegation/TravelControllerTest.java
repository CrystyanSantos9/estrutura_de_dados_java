package cryss.dev.estrutura_de_dados_java.refactoring.delegation;

import cryss.dev.estrutura_de_dados_java.refactoring.delegation.types.TrainTravell;
import cryss.dev.estrutura_de_dados_java.refactoring.delegation.types.TravellBooking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith (SpringExtension.class)
class TravelControllerTest {

    @InjectMocks
    TravelController travelController;

    @Spy
    TravellBooking delegatedObject = new TrainTravell ();

    @Test
    void bookingTrain(){

            TravellBooking mockTraingBookin = Mockito.mock(TrainTravell.class);

            travelController.bookTicket ();
            verify(delegatedObject, times (1)).bookTicket ();

        }

}