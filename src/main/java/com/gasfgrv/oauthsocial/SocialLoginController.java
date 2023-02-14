package com.gasfgrv.oauthsocial;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SocialLoginController {

    @GetMapping("home")
    public String homePage(Authentication authentication, Model model) {
        var user = (DefaultOAuth2User) authentication.getPrincipal();
        var attributes = user.getAttributes();

        var name = (String) attributes.get("name");
        model.addAttribute("name", name);

        return "home";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

}
