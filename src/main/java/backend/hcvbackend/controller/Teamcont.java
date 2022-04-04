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

import backend.hcvbackend.model.Team;
import backend.hcvbackend.repo.Teamrepo;

@CrossOrigin
@RestController
@RequestMapping("/teams")

public class Teamcont {
    @Autowired
    private Teamrepo teamrepo;

    @GetMapping("")
    List<Team> index(){
        return teamrepo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/AHDjdkso52Shh")
    Team creat(@RequestBody Team team){
        return teamrepo.save(team);
    }

    @PutMapping("/jdjdjMCd4SNS/{id}")
    Team update(@PathVariable String id,@RequestBody Team team){
        Team memberFromDB = teamrepo.findById(id).orElseThrow(RuntimeException::new);
        
        memberFromDB.setPost(team.getPost());
        memberFromDB.setFirstName(team.getFirstName());
        memberFromDB.setLastName(team.getLastName());
        memberFromDB.setDescr(team.getDescr());
        memberFromDB.setImg(team.getImg());
        memberFromDB.setImg(team.getTwitter());
        memberFromDB.setImg(team.getLinked());

        return teamrepo.save(memberFromDB);
    }    

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/HisisnlOSS55sxomS4/{id}")
    void delete(@PathVariable String id){
        Team memberToDelete = teamrepo.findById(id).orElseThrow(RuntimeException::new);
        teamrepo.delete(memberToDelete);
    }
}
