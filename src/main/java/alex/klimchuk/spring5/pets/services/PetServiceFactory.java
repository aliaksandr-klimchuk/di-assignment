package alex.klimchuk.spring5.pets.services;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
public class PetServiceFactory {

    public PetService getPetService(String petType) {
        switch (petType) {
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }

}
