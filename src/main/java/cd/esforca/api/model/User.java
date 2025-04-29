package cd.esforca.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String postnom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String motdepasse;
}
