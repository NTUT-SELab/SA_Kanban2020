package ddd.kanban.application.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "ddd.kanban.adapter.controller"
})

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(ddd.kanban.Application.class, args);
    }
}
