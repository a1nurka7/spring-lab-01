package kz.iitu.springlab.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemo {

    public LifecycleDemo() {
        System.out.println("LifecycleDemo: constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("LifecycleDemo: @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("LifecycleDemo: @PreDestroy");
    }
}