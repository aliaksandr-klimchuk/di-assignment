package alex.klimchuk.di.assignment.controllers;

import alex.klimchuk.di.pets.services.PetService;
import org.springframework.stereotype.Controller;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
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
