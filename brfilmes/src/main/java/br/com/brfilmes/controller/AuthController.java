package br.com.brfilmes.controller;

import br.com.brfilmes.model.User;
import br.com.brfilmes.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Controla o registros dos usuarios e garante a segurança do site

@Controller
public class AuthController {

    private final UserService userService;
    
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //Cuida do Login do usuario

    @PostMapping("/login")
    public String login(@RequestParam String email,
                       @RequestParam String password,
                       HttpSession session,
                       RedirectAttributes redirectAttributes) {
        
        if (userService.validateLogin(email, password)) {
            User user = userService.findByEmail(email).get();
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getName());
            return "redirect:/movies";
        } else {
            redirectAttributes.addFlashAttribute("error", "Email ou senha inválidos.");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    //Cuida do registro!
    @PostMapping("/register")
    public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success", "Registro concluído com sucesso! Faça login para continuar.");
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
