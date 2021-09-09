package vermeg.move.spring.service;
import java.util.List;
import vermeg.move.spring.entity.Itineraire;

public interface ItineraireService {
	public List<Itineraire> getAllItineraireByDeplacement(int id);
    public Itineraire getItineraireById(int id);
    public Itineraire addItineraire(Itineraire itineraire);
    public Itineraire editItineraire(Itineraire itineraire,int id);
    public void deleteItineraireById(int id);
}
