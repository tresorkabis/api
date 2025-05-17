package cd.esforca.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.esforca.api.model.User;
import cd.esforca.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> all() {
        return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<User> getByNom(String nom) {
        return repository.findByNom(nom);
    }
}
