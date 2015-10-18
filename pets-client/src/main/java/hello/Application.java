
package hello;

import pet.wsdl.GetPetResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(PetClient petClient) {
		return args -> {
	
			String petName = "Sooty";

			if (args.length > 0) {
				petName = args[0];
		
			}
			@SuppressWarnings("unused")
			GetPetResponse response = petClient.getPetResponse(petName);
			
		};
	}

}
