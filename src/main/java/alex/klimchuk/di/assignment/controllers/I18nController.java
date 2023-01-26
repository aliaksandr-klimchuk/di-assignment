package alex.klimchuk.di.assignment.controllers;

import alex.klimchuk.di.assignment.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Controller
public class I18nController {

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
