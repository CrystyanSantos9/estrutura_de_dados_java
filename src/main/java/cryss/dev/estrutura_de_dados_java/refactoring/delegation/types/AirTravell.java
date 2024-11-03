package cryss.dev.estrutura_de_dados_java.refactoring.delegation.types;

public class AirTravell implements TravellBooking{

    @Override
    public void bookTicket() {
        System.out.println ("Ticket was booked for air driver.");
    }
}
