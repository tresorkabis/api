package cd.esforca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cd.esforca.api.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {

}
