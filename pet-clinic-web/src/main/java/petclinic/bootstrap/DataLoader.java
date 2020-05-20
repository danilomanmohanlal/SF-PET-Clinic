package petclinic.bootstrap;

import com.example.springframework.model.Owner;
import com.example.springframework.model.Vet;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.VetService;
import com.example.springframework.services.map.OwnerServiceMap;
import com.example.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1l);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Fionna");
        owner2.setLastName("Gleananne");

        this.ownerService.save(owner2);
        System.out.println("owners loaded");

        Vet vet1 = new Vet();
        vet1.setId(1l);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2l);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);

        System.out.println("vets loaded");
    }
}
