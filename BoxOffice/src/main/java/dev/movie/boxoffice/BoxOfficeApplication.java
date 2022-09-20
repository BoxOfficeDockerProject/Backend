package dev.movie.boxoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BoxOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoxOfficeApplication.class, args);
    }

}
