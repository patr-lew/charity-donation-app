package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.exception.UserAlreadyExistException;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final UserService userService;

    @GetMapping("/register")
    public String getRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.validateAndRegisterNewUser(user);
        } catch (UserAlreadyExistException e) {
            log.debug("User with email {} already exists. Exception thrown: {}", user.getEmail(), e.getLocalizedMessage());
            return "redirect:/register?emailExists"; // TODO add info about existing email
        }

        return "redirect:/login";
    }
}
