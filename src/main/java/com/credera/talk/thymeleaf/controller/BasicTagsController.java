
package com.credera.talk.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/basic-tags")
public class BasicTagsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHome(HttpServletRequest request, Model model) {
        return "basic-tags";
    }
}
