package backend.hcvbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.hcvbackend.model.Customer;
import backend.hcvbackend.repo.Custumorrepo;

@CrossOrigin
@RestController
@RequestMapping("/customers")

public class Customercont {
    @Autowired
    private Custumorrepo custumorrepo;

    @GetMapping("")
    List<Customer> index(){
        return custumorrepo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Customer creat(@RequestBody Customer customer){
        return custumorrepo.save(customer);
    }

    @PutMapping("{id}")
    Customer update(@PathVariable String id,@RequestBody Customer team){
        Customer custumorFromDB = custumorrepo.findById(id).orElseThrow(RuntimeException::new);
        
        custumorFromDB.setPost(team.getPost());
        custumorFromDB.setFirstName(team.getFirstName());
        custumorFromDB.setLastName(team.getLastName());
        custumorFromDB.setDescr(team.getDescr());
        custumorFromDB.setImg(team.getImg());

        return custumorrepo.save(custumorFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Customer custumorToDelete = custumorrepo.findById(id).orElseThrow(RuntimeException::new);
        custumorrepo.delete(custumorToDelete);
    }

}
