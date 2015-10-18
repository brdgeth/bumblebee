
package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PetConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("pet.wsdl");
		return marshaller;
	}

	@Bean
	public PetClient weatherClient(Jaxb2Marshaller marshaller) {
		PetClient client = new PetClient();
		client.setDefaultUri("http://localhost:8080/ws/pets.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
