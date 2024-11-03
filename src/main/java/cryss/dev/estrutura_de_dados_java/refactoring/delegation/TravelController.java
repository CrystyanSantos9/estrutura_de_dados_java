package cryss.dev.estrutura_de_dados_java.refactoring.delegation;

import cryss.dev.estrutura_de_dados_java.refactoring.delegation.types.TravellBooking;

public class TravelController implements TravellBooking {

    private TravellBooking travellBooking;

    public TravelController(TravellBooking travellBooking) {
        this.travellBooking = travellBooking;
    }

    @Override
    public void bookTicket() {
        travellBooking.bookTicket ();
    }
}
