package kz.iitu.springlab.notify;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationService {

    private final Notifier primary;
    private final Notifier console;
    private final List<Notifier> all;
    private final Map<String, Notifier> byName;

    public NotificationService(
            Notifier primary,
            @Qualifier("console") Notifier console,
            List<Notifier> all,
            Map<String, Notifier> byName
    ) {
        this.primary = primary;
        this.console = console;
        this.all = all;
        this.byName = byName;
    }

    public String notifyAll(String message) {
        return "primary=" + primary.channel()
                + ", console=" + console.channel()
                + ", all=" + all.stream()
                .map(Notifier::channel)
                .toList()
                + ", byName=" + byName.keySet();
    }

    public String sendByName(String name, String message) {
        Notifier notifier = byName.get(name);

        if (notifier == null) {
            return "Unknown notifier: " + name;
        }

        return notifier.send(message);
    }
}