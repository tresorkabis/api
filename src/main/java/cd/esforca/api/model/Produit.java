package cd.esforca.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produit {
    @Id
    @Column(length = 10)
    private String reference;

    @Column(length = 100)
    private String designation;

    private Integer qte;

    private Integer prix;

    @ManyToOne(cascade = CascadeType.ALL)
    private Categorie categorie;
}
