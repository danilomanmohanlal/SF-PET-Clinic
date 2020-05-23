package com.example.springframework.bootstrap;

import com.example.springframework.model.*;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.PetTypeService;
import com.example.springframework.services.VetService;
import com.example.springframework.services.map.SpecialtyMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyMapService specialtyMapService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyMapService specialtyMapService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyMapService = specialtyMapService;
    }

    @Override
    public void run(String... args) throws Exception {

        int size = petTypeService.findAll().size();
        if (size == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyMapService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyMapService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyMapService.save(dentistry);

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
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("vets loaded");
    }
}
