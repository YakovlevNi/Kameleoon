package main.java.controllers;

import Quote.model.Quote;
import Quote.model.User;
import Quote.repositories.QuoteRepository;
import Quote.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;



    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromSQL = userRepository.findByUsername(user.getName());
        if (userFromSQL != null) {
            model.put("message", "User Exists");
            return "registration";
        }
        userRepository.save(user);
        return "redirect:/login";
    }


}
