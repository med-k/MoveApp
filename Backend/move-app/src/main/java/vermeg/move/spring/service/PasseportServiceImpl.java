package vermeg.move.spring.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vermeg.move.spring.entity.Passeport;
import vermeg.move.spring.repository.PasseportRepository;

@Service
public class PasseportServiceImpl implements PasseportService{

	
	@Autowired
	PasseportRepository passeportRepository;

	@Override
	public List<Passeport> getAllPasseport() {
		List<Passeport> listPasseport = new ArrayList<Passeport>();
		passeportRepository.findAll().forEach(x -> listPasseport.add(x));
		return listPasseport;
	}

	@Override
	public List<Passeport> getAllPasseportByCollaborateur(int id) {
		return passeportRepository.retrievePasseportByCollaborateur(id);
	}

	@Override
	public Passeport getPasseport(int id) {
		return passeportRepository.findById(id).get();
	}

	@Override
	public Passeport addPasseport(Passeport passeport) {
		return passeportRepository.save(passeport);
	}

	@Override
	public Passeport editPasseport(Passeport passeport,int id) {
		Passeport existingPasseport = passeportRepository.findById(id).get();
		if(passeport.getNumero() != null){
			existingPasseport.setNumero(passeport.getNumero());
		}
		if(passeport.getDateExpiration() != null){
			existingPasseport.setDateExpiration(passeport.getDateExpiration());
		}
		if(passeport.getPays() != null){
			existingPasseport.setPays(passeport.getPays());
		}
		if(passeport.getCollaborateur() != null){
			existingPasseport.setCollaborateur(passeport.getCollaborateur());
		}
		return passeportRepository.save(existingPasseport);
	}

	@Override
	public void deletePasseportById(int id) {
		passeportRepository.deleteById(id);
	}
	
}
