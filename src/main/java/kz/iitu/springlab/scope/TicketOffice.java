package kz.iitu.springlab.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class TicketOffice {

    private final ObjectProvider<Ticket> ticketProvider;

    public TicketOffice(ObjectProvider<Ticket> ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public Ticket issueTicket() {
        return ticketProvider.getObject();
    }
}