package alex.klimchuk.spring5.sfgdi.controllers;

import alex.klimchuk.spring5.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
public class PropertyInjectedControllerTest {

    private PropertyInjectedController controller;

    @BeforeEach
    public void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new ConstructorGreetingService();
    }

    @Test
    public void getGreeting() {
        System.out.println(controller.getGreeting());
    }

}
