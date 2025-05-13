package main.java.com.aitisal.web;

import com.aitisal.model.User;
import com.aitisal.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/users")
public class AuthController {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "users/login";
    }
}