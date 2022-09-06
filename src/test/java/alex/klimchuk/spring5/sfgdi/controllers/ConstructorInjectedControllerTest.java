package alex.klimchuk.spring5.sfgdi.controllers;

import alex.klimchuk.spring5.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController controller;

    @BeforeEach
    public void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    public void testGetGreeting() {
        System.out.println(controller.getGreeting());
    }

}
