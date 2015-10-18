package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pet.wsdl.GetPetRequest;
import pet.wsdl.GetPetResponse;
import pet.wsdl.Pet;

public class PetClient extends WebServiceGatewaySupport {
	
	private static final Logger log = LoggerFactory.getLogger(PetClient.class);
	
	public GetPetResponse getPetResponse(String petName){
		GetPetRequest request = new GetPetRequest();
		request.setName(petName);
		
		log.info("Requesting Pet details for " + petName);
		
		GetPetResponse response = (GetPetResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/pets.wsdl", 
				request, 
				new SoapActionCallback("http://localhost:8080/ws/getPetRequest"));
		log.info("Printing response");
		this.printResponse(response);
		return response;
	}
	
	public void printResponse(GetPetResponse response) {
		
		Pet petReturn = response.getPet();

		if(petReturn !=null){
			log.info("Pet received");

			Pet pet = response.getPet();
			log.info("pet name = " + pet.getName() );
			log.info("pet age = " + pet.getAge() );
			log.info("pet breed = " + pet.getBreed() );
			log.info("pet colour = " + pet.getColour() );
			log.info("");
		} else {
			log.info("No pet received");
		}
	}
	
}
