package cd.esforca.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.esforca.api.model.Categorie;
import cd.esforca.api.repository.CategorieRepository;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repository;

    public List<Categorie> all(){
        return repository.findAll();
    }

    public void save(Categorie categorie){
        repository.save(categorie);
    }

    public Optional<Categorie> get(String code){
        return repository.findById(code);
    }

    public void delete(String code){
        repository.deleteById(code);
    }
}
