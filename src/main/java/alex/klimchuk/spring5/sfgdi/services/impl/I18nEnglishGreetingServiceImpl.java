package alex.klimchuk.spring5.sfgdi.services.impl;

import alex.klimchuk.spring5.sfgdi.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }

}
