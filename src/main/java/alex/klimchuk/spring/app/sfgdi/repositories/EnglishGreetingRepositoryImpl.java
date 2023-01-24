package alex.klimchuk.spring.app.sfgdi.repositories;

//import org.springframework.stereotype.Repository;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
//@Repository
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }

}
