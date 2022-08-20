package alex.klimchuk.spring5.sfgdi.services.impl;

import alex.klimchuk.spring5.sfgdi.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Service
@Profile({"dog", "default"})
public class DogPetServiceImpl implements PetService {

    public String getPetType() {
        return "Dogs are the best!";
    }

}
