package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/login";
    }


}
