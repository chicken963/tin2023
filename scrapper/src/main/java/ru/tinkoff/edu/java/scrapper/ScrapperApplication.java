package ru.tinkoff.edu.java.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.scrapper.configuration.ScrapperConfig;

@SpringBootApplication
@EnableConfigurationProperties(ScrapperConfig.class)
public class ScrapperApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication.class, args);
        ScrapperConfig config = ctx.getBean(ScrapperConfig.class);
        System.out.println(config);
    }
}

