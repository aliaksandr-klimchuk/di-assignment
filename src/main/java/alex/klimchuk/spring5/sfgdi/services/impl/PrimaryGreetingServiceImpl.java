package alex.klimchuk.spring5.sfgdi.services.impl;

import alex.klimchuk.spring5.sfgdi.services.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Primary
@Service
public class PrimaryGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean";
    }

}
