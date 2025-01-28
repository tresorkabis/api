package cd.esforca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cd.esforca.api.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, String> {

}
