package alex.klimchuk.spring5.pets.services;

//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
//@Service
//@Profile({"dog", "default"})
public class DogPetService implements PetService {

    public String getPetType() {
        return "Dogs are the best!";
    }

}
