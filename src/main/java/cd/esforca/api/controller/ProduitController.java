package cd.esforca.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cd.esforca.api.model.Produit;
import cd.esforca.api.service.ProduitService;


public class ProduitController {

    @Autowired
    private ProduitService service;

    @GetMapping("/produits")
    public List<Produit> all(){
        return service.all();
    }

    @GetMapping("/produits/{reference}")
    public ResponseEntity<Produit> get(@PathVariable String reference) {
        try {
            Produit produit = service.get(reference).get();
            return new ResponseEntity<Produit>(produit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Produit>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/produits")
    public void add(@RequestBody Produit produit){
        service.save(produit);
    }

    @PutMapping("/produits/{reference}")
    public ResponseEntity<?> update(@RequestBody Produit produit, @PathVariable String reference){
        try {
            Produit existproduit = service.get(produit.getReference()).get();
            service.save(produit);
            return new ResponseEntity<Produit>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/produits/{reference}")
    public void delete(@PathVariable String reference){
        service.delete(reference);
    }
}
