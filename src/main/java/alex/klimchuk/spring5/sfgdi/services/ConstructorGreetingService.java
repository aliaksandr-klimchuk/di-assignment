package alex.klimchuk.spring5.sfgdi.services;

//import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
//@Service
public class ConstructorGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }

}
