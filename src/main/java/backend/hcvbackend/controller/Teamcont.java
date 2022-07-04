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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import backend.hcvbackend.model.Team;
import backend.hcvbackend.repo.Teamrepo;
import backend.hcvbackend.service.ImageService;

@CrossOrigin
@RestController
@RequestMapping("/teams")

public class Teamcont {
    @Autowired
    private Teamrepo teamrepo;
    
    @Autowired
    private ImageService imageService;

    private String imageUrl;

    @GetMapping("")
    List<Team> index(){
        return teamrepo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/AHDjdkso52Shh")
    public Team creat(
        @RequestPart(name = "image") MultipartFile[] files,
        @RequestPart(required = false) String atr,
        @RequestPart(required = false) String post,
        @RequestPart(required = false) String firstName,
        @RequestPart(required = false) String lastName,
        @RequestPart(required = false) String descr,
        @RequestPart(required = false) String twitter,
        @RequestPart(required = false) String linked
    ){
        for (MultipartFile file : files) {
            try {
                String fileName = imageService.save(file);
                this.imageUrl = imageService.getImageUrl(fileName);

            } catch (Exception e) {
                System.out.println("no");
            }
        }

        Team team = new Team();
        team.setAtr(atr);
        team.setDescr(descr);
        team.setFirstName(firstName);
        team.setImgURL(imageUrl);
        team.setLastName(lastName);
        team.setLinked(linked);
        team.setPost(post);
        team.setTwitter(twitter);
        
        return teamrepo.save(team);
    }

    @PutMapping("/jdjdjMCd4SNS/{id}")
    Team update(@PathVariable String id,@RequestBody Team team){
        Team memberFromDB = teamrepo.findById(id).orElseThrow(RuntimeException::new);
        
        memberFromDB.setPost(team.getPost());
        memberFromDB.setFirstName(team.getFirstName());
        memberFromDB.setLastName(team.getLastName());
        memberFromDB.setDescr(team.getDescr());
        memberFromDB.setImgURL(team.getImgURL());
        memberFromDB.setAtr(team.getAtr());
        memberFromDB.setTwitter(team.getTwitter());
        memberFromDB.setLinked(team.getLinked());

        return teamrepo.save(memberFromDB);
    }    

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/HisisnlOSS55sxomS4/{id}")
    void delete(@PathVariable String id){
        Team memberToDelete = teamrepo.findById(id).orElseThrow(RuntimeException::new);
        teamrepo.delete(memberToDelete);
    }
}
