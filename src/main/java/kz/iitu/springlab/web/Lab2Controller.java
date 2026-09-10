package kz.iitu.springlab.web;

import kz.iitu.springlab.notify.NotificationService;
import kz.iitu.springlab.notify.Notifier;
import kz.iitu.springlab.scope.Ticket;
import kz.iitu.springlab.scope.TicketOffice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab2Controller {

    private final NotificationService notificationService;
    private final TicketOffice ticketOffice;
    private final Notifier timestampedNotifier;

    public Lab2Controller(
            NotificationService notificationService,
            TicketOffice ticketOffice,
            @Qualifier("timestamped") Notifier timestampedNotifier
    ) {
        this.notificationService = notificationService;
        this.ticketOffice = ticketOffice;
        this.timestampedNotifier = timestampedNotifier;
    }

    @GetMapping("/api/lab2/notify")
    public String notify(@RequestParam(defaultValue = "Hello") String message) {
        return notificationService.notifyAll(message);
    }

    @GetMapping("/api/lab2/lifecycle")
    public String lifecycle() {
        return "LifecycleDemo is active";
    }

    @GetMapping("/api/lab2/scopes")
    public String scopes() {
        Ticket ticket1 = ticketOffice.issueTicket();
        Ticket ticket2 = ticketOffice.issueTicket();

        return "ticket1=" + ticket1.getId()
                + ", ticket2=" + ticket2.getId()
                + ", same=" + (ticket1 == ticket2);
    }

    @GetMapping("/api/lab2/custom")
    public String custom(@RequestParam(defaultValue = "Hello") String text) {
        return timestampedNotifier.send(text);
    }
}
