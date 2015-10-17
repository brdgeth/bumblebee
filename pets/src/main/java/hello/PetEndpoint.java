package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost.pets.bh_producing_soap_web_service_pets.GetPetRequest;
import localhost.pets.bh_producing_soap_web_service_pets.GetPetResponse;

@Endpoint
public class PetEndpoint {
	private static final String NAMESPACE_URI = "http://localhost/pets/bh-producing-soap-web-service-pets";

	private PetRepository petRepository;

	@Autowired
	public PetEndpoint(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPetRequest")
	@ResponsePayload
	public GetPetResponse getPet(@RequestPayload GetPetRequest request) {
		GetPetResponse response = new GetPetResponse();
		response.setPet(petRepository.findPet(request.getName()));
		return response;
	}
}
