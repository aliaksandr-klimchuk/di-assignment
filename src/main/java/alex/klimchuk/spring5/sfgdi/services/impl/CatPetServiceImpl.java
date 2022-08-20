package alex.klimchuk.spring5.sfgdi.services.impl;

import alex.klimchuk.spring5.sfgdi.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */

@Service
@Profile("cat")
public class CatPetServiceImpl implements PetService {

    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }

}
