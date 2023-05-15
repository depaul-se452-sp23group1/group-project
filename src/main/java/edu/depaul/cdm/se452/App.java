package edu.depaul.cdm.se452;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
@Log4j2
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
