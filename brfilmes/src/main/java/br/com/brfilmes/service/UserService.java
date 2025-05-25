package br.com.brfilmes.service;

import br.com.brfilmes.model.User;
import br.com.brfilmes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// confirma o usuario para ocorrer tudo da maneira certa
// Valida registros, autentica logins e gerencia contas


@Service
public class UserService {

    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email já está em uso");
        }
        return userRepository.save(user);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public boolean validateLogin(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getPassword().equals(password) && user.isActive();
        }
        return false;
    }
}
