
package com.credera.talk.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/prototype", method = RequestMethod.GET)
    public String getPrototype(HttpServletRequest request, Model model) {
        model.addAttribute("message", "Welcome to the Thymeleaf Demo!");
        return "index-prototype";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHome(HttpServletRequest request, Model model) {
        return "index";
    }
}
