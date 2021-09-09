package vermeg.move.spring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vermeg.move.spring.entity.Itineraire;
import vermeg.move.spring.repository.ItineraireRepository;

@Service
public class ItineraireServiceImpl implements ItineraireService{
	
	@Autowired
	ItineraireRepository itineraireRepository;

	@Override
	public List<Itineraire> getAllItineraireByDeplacement(int id) {
		return itineraireRepository.retrieveAllItineraireByDeplacement(id);
	}

	@Override
	public Itineraire getItineraireById(int id) {
		return itineraireRepository.findById(id).get();
	}

	@Override
	public Itineraire addItineraire(Itineraire itineraire) {
		return itineraireRepository.save(itineraire);
	}

	@Override
	public Itineraire editItineraire(Itineraire itineraire,int id) {
		Itineraire existingItineraire = itineraireRepository.findById(id).get();
		existingItineraire.setBillet(itineraire.getBillet());
		existingItineraire.setDeplacement(itineraire.getDeplacement());
		existingItineraire.setHeureArrivee(itineraire.getHeureArrivee());
		existingItineraire.setHeureDepart(itineraire.getHeureDepart());
		existingItineraire.setModeTransport(itineraire.getModeTransport());
		existingItineraire.setPointArrivee(itineraire.getPointArrivee());
		existingItineraire.setPointDepart(itineraire.getPointDepart());
		return itineraireRepository.save(existingItineraire);
	}

	@Override
	public void deleteItineraireById(int id) {
		itineraireRepository.deleteById(id);
	}
	
}
