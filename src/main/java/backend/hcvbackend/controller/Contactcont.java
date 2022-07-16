package backend.hcvbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import backend.hcvbackend.model.Contact;
import backend.hcvbackend.service.JavaMailSender;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class Contactcont {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(
        @RequestPart(required = false) String fullname,
        @RequestPart(required = false) String email,
        @RequestPart(required = false) String object,
        @RequestPart(required = false) String subject){

        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setFullname(fullname);
        contact.setObject(object);
        contact.setSubject(subject);
       
        String emailText= contact.getSubject()+"\n\n Nom et prénom : "+contact.getFullname()+"\n Email: "+contact.getEmail();
       
        JavaMailSender javaMailSender = new  JavaMailSender();
        javaMailSender.sendEmail(contact.getObject(), emailText);

        }

}
