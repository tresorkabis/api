package cd.esforca.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cd.esforca.api.model.Categorie;
import cd.esforca.api.service.CategorieService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CategorieController {

    @Autowired
    private CategorieService service;

    @GetMapping("/categories")
    public List<Categorie> all(){
        return service.all();
    }

    @GetMapping("/categories/{code}")
    public ResponseEntity<Categorie> get(@PathVariable String code) {
        try {
            Categorie categorie = service.get(code).get();
            return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories")
    public void add(@RequestBody Categorie categorie){
        service.save(categorie);
    }

    @PutMapping("/categories/{code}")
    public ResponseEntity<?> update(@RequestBody Categorie categorie, @PathVariable String code){
        try {
            Categorie existCategorie = service.get(code).get();
            service.save(categorie);
            return new ResponseEntity<Categorie>(existCategorie, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{code}")
    public void delete(@PathVariable String code){
        service.delete(code);
    }
    
}
