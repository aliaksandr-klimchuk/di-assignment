package alex.klimchuk.spring5.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Service("i18nService")
@Profile({"ES", "default"})
public class I18NSpanishService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }

}
