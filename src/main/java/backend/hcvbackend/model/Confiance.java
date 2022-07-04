package backend.hcvbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Confiance {
    @Id
    private String id;
    private String imgURL;
    private String atr;
    private String secteur;
}
