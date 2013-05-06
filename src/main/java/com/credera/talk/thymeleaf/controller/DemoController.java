
package com.credera.talk.thymeleaf.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.credera.talk.thymeleaf.domain.User;

public abstract class DemoController {

    @ModelAttribute("user")
    public User getUser() {
        return new User("Justin", "Munn");
    }
}
