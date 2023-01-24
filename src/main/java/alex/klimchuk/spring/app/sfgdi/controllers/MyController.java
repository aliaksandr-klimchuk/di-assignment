package alex.klimchuk.spring.app.sfgdi.controllers;

import alex.klimchuk.spring.app.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
