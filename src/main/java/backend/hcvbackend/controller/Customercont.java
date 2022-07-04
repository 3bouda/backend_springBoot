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

import backend.hcvbackend.model.Customer;
import backend.hcvbackend.repo.Custumorrepo;
import backend.hcvbackend.service.ImageService;

@CrossOrigin
@RestController
@RequestMapping("/customers")

public class Customercont {
    @Autowired
    private Custumorrepo custumorrepo;

    @Autowired
    private ImageService imageService;

    private String imageUrl;

    @GetMapping("")
    List<Customer> index() {
        return custumorrepo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/AHDjdkj451SHS")
    public Customer creat(
            @RequestPart(name = "image") MultipartFile[] files,
            @RequestPart(required = false) String atr,
            @RequestPart(required = false) String societe,
            @RequestPart(required = false) String post,
            @RequestPart(required = false) String firstName,
            @RequestPart(required = false) String lastName,
            @RequestPart(required = false) String descr) {

        for (MultipartFile file : files) {
            try {
                String fileName = imageService.save(file);
                this.imageUrl = imageService.getImageUrl(fileName);

            } catch (Exception e) {
                System.out.println("no");
            }
        }

        Customer customer = new Customer();
        customer.setAtr(atr);
        customer.setDescr(descr);
        customer.setFirstName(firstName);
        customer.setImgURL(imageUrl);
        customer.setLastName(lastName);
        customer.setPost(post);
        customer.setSociete(societe);
        return custumorrepo.save(customer);
    }

    @PutMapping("/SXLSXNXS/{id}")
    Customer update(@PathVariable String id, @RequestBody Customer customer) {
        Customer custumorFromDB = custumorrepo.findById(id).orElseThrow(RuntimeException::new);

        custumorFromDB.setPost(customer.getPost());
        custumorFromDB.setSociete(customer.getSociete());
        custumorFromDB.setFirstName(customer.getFirstName());
        custumorFromDB.setLastName(customer.getLastName());
        custumorFromDB.setDescr(customer.getDescr());
        custumorFromDB.setImgURL(customer.getImgURL());
        custumorFromDB.setAtr(customer.getAtr());
        return custumorrepo.save(custumorFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sxlxsnSX511SSX/{id}")
    void delete(@PathVariable String id) {
        Customer custumorToDelete = custumorrepo.findById(id).orElseThrow(RuntimeException::new);
        custumorrepo.delete(custumorToDelete);
    }

}
