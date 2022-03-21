package backend.hcvbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.hcvbackend.model.Team;

public interface Teamrepo extends MongoRepository<Team,String> {
    
}
