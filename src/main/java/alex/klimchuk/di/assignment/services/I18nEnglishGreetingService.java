package alex.klimchuk.di.assignment.services;

//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;

import alex.klimchuk.di.assignment.repositories.EnglishGreetingRepository;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }

}
