package pt.jpborges.configserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pt.jpborges.configserver.repository.mongo.model.ConfigParam;
import pt.jpborges.configserver.repository.mongo.model.MongoEnvironmentRepository;
import pt.jpborges.configserver.services.PingService;


@SpringBootApplication
public class ConfigServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }





}
