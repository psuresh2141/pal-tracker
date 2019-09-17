package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    private final String WELCOME_MESSAGE;

    public WelcomeController(@Value("${welcome.message}") String message) {
        this.WELCOME_MESSAGE = message;
    }

    @RequestMapping("/")
    public String sayHello(){
        return WELCOME_MESSAGE;
    }
}
