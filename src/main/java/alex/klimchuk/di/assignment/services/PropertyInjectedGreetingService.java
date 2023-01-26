package alex.klimchuk.di.assignment.services;

//import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
//@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }

}
