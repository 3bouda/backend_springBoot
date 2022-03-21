package backend.hcvbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.hcvbackend.model.Customer;

public interface Custumorrepo extends MongoRepository<Customer,String>{
    
}
