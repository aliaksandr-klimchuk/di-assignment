package alex.klimchuk.di.assignment.controllers;

import alex.klimchuk.di.assignment.services.ConstructorGreetingService;
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
    public void testGetGreeting() {
        System.out.println(controller.getGreeting());
    }

}
