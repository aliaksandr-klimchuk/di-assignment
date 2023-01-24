package alex.klimchuk.spring.app.sfgdi.services;

import org.springframework.stereotype.Component;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton Bean!");
    }

    public String getScope() {
        return "Singleton";
    }

}
