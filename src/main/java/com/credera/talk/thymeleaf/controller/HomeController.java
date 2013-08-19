
package com.credera.talk.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController extends DemoController {

    @RequestMapping(value = "/prototype", method = RequestMethod.GET)
    public String getPrototype(HttpServletRequest request, Model model) {
        model.addAttribute("message", "Welcome to the Thymeleaf Demo!");
        return "fullPage/index-prototype";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHome(HttpServletRequest request, Model model) {
        return "fullPage/index";
    }

    @RequestMapping(value = "/jsp", method = RequestMethod.GET)
    public String getJSP(HttpServletRequest request, Model model) {
        model.addAttribute("message", "(JSP version)");
        return "jsp/index";
    }

    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    public String getlayout(HttpServletRequest request, Model model) {
        return "layout/index-layout";
    }
}
