package backend.hcvbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Customer {
    @Id
    private String id;
    private String post;
    private String firstName;
    private String lastName;
    private String descr;
    private String img;
}
