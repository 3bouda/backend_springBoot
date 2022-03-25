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

import backend.hcvbackend.model.Confiance;
import backend.hcvbackend.repo.Confiancerepo;

@CrossOrigin
@RestController
@RequestMapping("/confiance")

public class Confiancecont {
    @Autowired
    private Confiancerepo confiancerepo;

    @GetMapping("")
    List<Confiance> index(){
        return confiancerepo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/AbcestQ45")
    Confiance creat(@RequestBody Confiance confiance){
        return confiancerepo.save(confiance);
    }

    @PutMapping("/Zfhhkji/{id}")
    Confiance update(@PathVariable String id,@RequestBody Confiance confiance){
        Confiance memberFromDB = confiancerepo.findById(id).orElseThrow(RuntimeException::new);
        
        memberFromDB.setAtr(confiance.getAtr());
        memberFromDB.setImg(confiance.getImg());

        return confiancerepo.save(memberFromDB);
    } 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/khoSDF5FTdfy/{id}")
    void delete(@PathVariable String id){
        Confiance confianceToDelete = confiancerepo.findById(id).orElseThrow(RuntimeException::new);
        confiancerepo.delete(confianceToDelete);
    }
}
