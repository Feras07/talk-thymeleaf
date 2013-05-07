
package com.credera.talk.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplateController extends DemoController {

    @RequestMapping(value = "{templateName}", method = RequestMethod.GET)
    public String getBasics1(HttpServletRequest request, Model model,
            @PathVariable("templateName") String templateName) {
        return templateName + "/" + templateName + "-1";
    }

    @RequestMapping(value = "{templateName}/{pathId}", method = RequestMethod.GET)
    public String getBasicsDynamic(HttpServletRequest request, Model model,
            @PathVariable("templateName") String templateName,
            @PathVariable("pathId") String pathId) {
        return templateName + "/" + templateName + "-" + pathId;
    }
}
