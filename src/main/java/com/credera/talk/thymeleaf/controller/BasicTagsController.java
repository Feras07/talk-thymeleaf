
package com.credera.talk.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/basic-tags")
public class BasicTagsController extends DemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String getTags1(HttpServletRequest request, Model model) {
        return "basic-tags/basic-tags-1";
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public String getTags2(HttpServletRequest request, Model model) {
        return "basic-tags/basic-tags-2";
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public String getTags3(HttpServletRequest request, Model model) {
        return "basic-tags/basic-tags-3";
    }
}
