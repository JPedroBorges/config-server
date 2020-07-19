package pt.jpborges.configserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.jpborges.configserver.repository.mongo.model.ConfigParam;
import pt.jpborges.configserver.repository.mongo.model.MongoEnvironmentRepository;

import java.util.List;

@Service
public class PingService {


    @Autowired
    private MongoEnvironmentRepository repository;

    public String testConfigService() {
        System.out.println("ping request");
        return "alive";
    }

    public String testMongoService() {
        System.out.println("ping request");
        return "alive";
    }

    public List<ConfigParam> testData(){
        repository.deleteAll();

        repository.save(new ConfigParam("PRD", "asd", true));
        repository.save(new ConfigParam("QAS", "asd", true));
        repository.save(new ConfigParam("DEV", "asd", true));

       return repository.findAll();
    }
}
