package hello;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import localhost.pets.bh_producing_soap_web_service_pets.Pet;

@Component
public class PetRepository {

	private static final List<Pet> pets = new ArrayList<Pet>();
	
	@PostConstruct
	public void initData() {
		
		Pet vienna = new Pet();
		vienna.setName("Vienna");
		vienna.setAge(4);
		vienna.setBreed("black and white one");
		vienna.setColour("Black and White");

		pets.add(vienna);
		
		Pet gio = new Pet();
		gio.setName("Gio");
		gio.setAge(15);
		gio.setBreed("Ginger Tabby");
		gio.setColour("Ginger");
		
		pets.add(gio);
		
		Pet sooty = new Pet();
		sooty.setName("Sooty");
		sooty.setAge(20);
		sooty.setBreed("Black cat");
		sooty.setColour("Black");
		
		pets.add(sooty);

	}

	public Pet findPet(String name) {
		Assert.notNull(name);

		Pet result = null;

		for (Pet pet : pets){
			if(name.equals(pet.getName())){
				result = pet;
			}
		}

		return result;
	}
}
