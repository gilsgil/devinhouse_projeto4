package com.vila.devinhouse.projeto4.controller;

import com.vila.devinhouse.projeto4.model.ConfirmationToken;
import com.vila.devinhouse.projeto4.model.User;
import com.vila.devinhouse.projeto4.service.ConfirmationTokenService;
import com.vila.devinhouse.projeto4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(Model model, User user) {
        model.addAttribute("user", new User());
        userService.signUpUser(user);
        return "redirect:/sign-in";
    }

    @GetMapping("/confirm/{token}")
    String confirmMail(@PathVariable("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "/sign-in";
    }

}