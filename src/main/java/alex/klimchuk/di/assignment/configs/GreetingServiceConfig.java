package alex.klimchuk.di.assignment.configs;

import alex.klimchuk.di.pets.services.PetService;
import alex.klimchuk.di.pets.services.PetServiceFactory;
import alex.klimchuk.di.assignment.datasource.FakeDataSource;
import alex.klimchuk.di.assignment.repositories.EnglishGreetingRepository;
import alex.klimchuk.di.assignment.repositories.EnglishGreetingRepositoryImpl;
import alex.klimchuk.di.assignment.services.*;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Configuration
@ImportResource("classpath:spring-config.xml")
//@PropertySource("classpath:datasource.properties")
@EnableConfigurationProperties(SfgDiConstructorConfig.class)
public class GreetingServiceConfig {

//    @Bean
//    FakeDataSource fakeDataSource(@Value("${spring.data.username}") String username,
//                                  @Value("${spring.data.password}") String password,
//                                  @Value("${spring.data.jdbcUrl}") String jdbcUrl) {
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcUrl(jdbcUrl);
//        return fakeDataSource;
//    }

//    @Bean
//    FakeDataSource fakeDataSource(SfgdiConfiguration sfgdiConfiguration) {
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(sfgdiConfiguration.getUsername());
//        fakeDataSource.setPassword(sfgdiConfiguration.getPassword());
//        fakeDataSource.setJdbcUrl(sfgdiConfiguration.getJdbcUrl());
//        return fakeDataSource;
//    }

    @Bean
    FakeDataSource fakeDataSource(SfgDiConstructorConfig sfgdiConstructorConfig) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgdiConstructorConfig.getUsername());
        fakeDataSource.setPassword(sfgdiConstructorConfig.getPassword());
        fakeDataSource.setJdbcUrl(sfgdiConstructorConfig.getJdbcUrl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

}
