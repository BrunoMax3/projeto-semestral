package br.com.brfilmes.controller;

import br.com.brfilmes.model.User;
import br.com.brfilmes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
//Busca os usuarios cadastrados no sistema com o banco de dados e exibe em html
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        System.out.println("user" + users);
        return "users";

    }
}
