package alex.klimchuk.spring5.sfgdi.controllers;

import alex.klimchuk.spring5.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    @Autowired
    @Qualifier("setterInjectedGreetingServiceImpl")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

}
