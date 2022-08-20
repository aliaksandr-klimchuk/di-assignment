package alex.klimchuk.spring5.sfgdi.services.impl;

import alex.klimchuk.spring5.sfgdi.services.GreetingService;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Service
public class SetterInjectedGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }

}
