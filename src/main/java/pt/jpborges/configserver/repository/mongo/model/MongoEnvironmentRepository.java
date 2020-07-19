package pt.jpborges.configserver.repository.mongo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MongoEnvironmentRepository extends MongoRepository<ConfigParam, String> {
    Optional<ConfigParam> findById(String aId);
    List<ConfigParam> findByLabel(String aLabel);
}
