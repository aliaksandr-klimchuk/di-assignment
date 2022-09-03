package alex.klimchuk.spring5.sfgdi.controllers;

import alex.klimchuk.spring5.pets.services.PetService;
import org.springframework.stereotype.Controller;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest() {
        return petService.getPetType();
    }

}
