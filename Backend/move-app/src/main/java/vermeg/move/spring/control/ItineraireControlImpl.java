package vermeg.move.spring.control;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermeg.move.spring.entity.Itineraire;
import vermeg.move.spring.service.ItineraireServiceImpl;

@RestController
public class ItineraireControlImpl {

	@Autowired
	ItineraireServiceImpl itineraireServiceImpl;
	
	/*------Get------*/
	
	@RolesAllowed({ "admin", "director","manager","agent","collaborater" })
	@GetMapping("/itineraire/{id}")
	@ResponseBody
	public Itineraire getItineraireById(@RequestHeader String Authorization,@PathVariable("id") int id){
		return itineraireServiceImpl.getItineraireById(id);
	}
	
	@RolesAllowed({ "admin", "director","manager","agent","collaborater" })
	@GetMapping("/itineraire/deplacement/{id}")
	@ResponseBody
	public List<Itineraire> getAllItineraireByDeplacement(@RequestHeader String Authorization,@PathVariable("id") int id){
		return itineraireServiceImpl.getAllItineraireByDeplacement(id);
	}
	
	/*------POST------*/
	
	@RolesAllowed({ "admin","agent" })
	@PostMapping("/itineraire")
	@ResponseBody
	public Itineraire addItineraire(@RequestHeader String Authorization,@RequestBody Itineraire itineraire){
		return itineraireServiceImpl.addItineraire(itineraire);
	}
	
	/*------PUT------*/
	
	@RolesAllowed({ "admin","agent" })
	@PutMapping("/itineraire/{id}")
	@ResponseBody
	public Itineraire editItineraire(@RequestHeader String Authorization,@RequestBody Itineraire itineraire,@PathVariable("id") int id){
		return itineraireServiceImpl.editItineraire(itineraire, id);
	}
	
	/*------DELETE------*/
	
	@RolesAllowed({ "admin","agent" })
	@DeleteMapping("/itineraire/{id}")
	@ResponseBody
	public void deleteItineraireById(@RequestHeader String Authorization,@PathVariable("id") int id){
		itineraireServiceImpl.deleteItineraireById(id);
	}
	
}
