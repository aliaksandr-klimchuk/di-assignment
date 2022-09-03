package alex.klimchuk.spring5.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Creating a Prototype Bean!");
    }

    public String getScope() {
        return "Prototype";
    }

}
