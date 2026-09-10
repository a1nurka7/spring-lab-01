package kz.iitu.springlab;

import kz.iitu.springlab.notify.Notifier;
import kz.iitu.springlab.notify.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ContainerReport implements CommandLineRunner {

    private final ApplicationContext context;

    public ContainerReport(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
        String[] beanNames = context.getBeanDefinitionNames();

        System.out.println("=== Container Report ===");
        System.out.println("Bean count: " + beanNames.length);

        System.out.println("Notifier beans:");
        Arrays.stream(context.getBeanNamesForType(Notifier.class))
                .forEach(name -> System.out.println(" - " + name));

        System.out.println("NotificationService class: "
                + context.getBean(NotificationService.class).getClass().getName());
    }
}
