package cd.esforca.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categorie {
    
    @Id
    @Column(length = 10)
    private String code;

    @Column(length = 100)
    private String titre;
}
