package cd.esforca.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.esforca.api.model.Produit;
import cd.esforca.api.repository.ProduitRepository;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository repository;

    public List<Produit> all(){
        return repository.findAll();
    }

    public void save(Produit produit){
        repository.save(produit);
    }

    public Optional<Produit> get(String reference){
        return repository.findById(reference);
    }

    public void delete(String reference){
        repository.deleteById(reference);
    }
}
