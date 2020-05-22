package com.example.springframework.bootstrap;

import com.example.springframework.model.Owner;
import com.example.springframework.model.Pet;
import com.example.springframework.model.PetType;
import com.example.springframework.model.Vet;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.PetTypeService;
import com.example.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setTelephone("123645478");
        owner1.setAddress("Lisbon");
        owner1.setCity("Lisbon");

        Pet myPet = new Pet();
        myPet.setName("Rosco");
        myPet.setOwner(owner1);
        myPet.setBirthDate(LocalDate.now());
        myPet.setPetType(savedDogType);
        owner1.getPets().add(myPet);

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Gleananne");
        owner2.setTelephone("879865425");
        owner2.setAddress("Lisbon");
        owner2.setCity("Lisbon");

        Pet fionasCat = new Pet();
        fionasCat.setName("Fionas Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatType);
        owner2.getPets().add(fionasCat);

        this.ownerService.save(owner2);
        System.out.println("owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);

        System.out.println("vets loaded");
    }
}
