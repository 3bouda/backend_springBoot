package backend.hcvbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.hcvbackend.model.Confiance;

public interface Confiancerepo extends MongoRepository<Confiance,String>{
    
}
