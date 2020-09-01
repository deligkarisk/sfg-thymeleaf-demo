package com.deligkarisk.sfgthymeleafdemo.controllers;

import com.deligkarisk.sfgthymeleafdemo.commands.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginCommand", new LoginCommand());
        return "loginform";
    }

    @PostMapping("/dologin")
    public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            return "loginform";
        }
        return "/";
    }
}
