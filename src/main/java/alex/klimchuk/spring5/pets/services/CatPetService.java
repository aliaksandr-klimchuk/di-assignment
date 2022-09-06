package alex.klimchuk.spring5.pets.services;

//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
//@Service
//@Profile("cat")
public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }

}
