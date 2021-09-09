package vermeg.move.spring.service;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vermeg.move.spring.entity.Collaborateur;
import vermeg.move.spring.repository.CollaborateurRepository;
import vermeg.move.spring.repository.RoleRepository;


@Service
public class CollaborateurServiceImpl implements CollaborateurService {
	
	@Autowired
	CollaborateurRepository collaborateurRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Override
	public Set<Collaborateur> getAllCollaborateur() {
		Set<Collaborateur> listCollaborateur = new HashSet<Collaborateur>();
		collaborateurRepository.findAll().forEach(x -> listCollaborateur.add(x));
		return (Set<Collaborateur>) listCollaborateur;
	}
	

	@Override
	public Set<Collaborateur> getAllCollaborateurByDirector(int id) {
		Collaborateur director = collaborateurRepository.findById(id).get();
		Set<Collaborateur> equipe = director.getEquipe();
		Set<Collaborateur> listCollaborateur = new HashSet<Collaborateur>();
		listCollaborateur.addAll(equipe);
		equipe.forEach(x -> {
			listCollaborateur.addAll(this.getAllCollaborateurByManager(x.getId()));
		});
		return listCollaborateur;
	}
	
	@Override
	public Set<Collaborateur> getAllCollaborateurByManager(int id) {
		Collaborateur manager = collaborateurRepository.findById(id).get();
		Set<Collaborateur> listCollaborateur = manager.getEquipe();
		return   listCollaborateur;
	}


	@Override
	public Collaborateur getCollaborateurById(int id) {
		return collaborateurRepository.findById(id).get();
	}
	

	@Override
	public Collaborateur addCollaborateur(Collaborateur collaborateur) {
		collaborateur.addSupervisorEquipe();
		return collaborateurRepository.save(collaborateur); 
	}
	
	@Override
	public Collaborateur modifierCollaborateur(Collaborateur collaborateur,int id) {
		Collaborateur existingCollaborateur = collaborateurRepository.findById(id).get();
		if(collaborateur.getNom() != null){
			existingCollaborateur.setNom(collaborateur.getNom());
		}
		if(collaborateur.getPrenom() != null){
			existingCollaborateur.setPrenom(collaborateur.getPrenom());
		}
		if(collaborateur.getEmail() != null){
			existingCollaborateur.setEmail(collaborateur.getEmail());
		}
		if(collaborateur.getNumTel() != null){
			existingCollaborateur.setNumTel(collaborateur.getNumTel());
		}
		if(collaborateur.getCin() != null){
			existingCollaborateur.setCin(collaborateur.getCin());
		}
		if(collaborateur.getAdresse() != null){
			existingCollaborateur.setAdresse(collaborateur.getAdresse());
		}
		if(collaborateur.getSuperviseur().equals(existingCollaborateur.getSuperviseur()) == false){
			existingCollaborateur.removeSupervisorEquipe();
			existingCollaborateur.setSuperviseur(collaborateur.getSuperviseur());
			existingCollaborateur.addSupervisorEquipe();
		}
		return collaborateurRepository.save(existingCollaborateur);
	}

	@Override
	public void deleteCollaborateurById(int id) {
		collaborateurRepository.deleteById(id);	
	}


	@Override
	public int getCollaborateurIdByEmail(String email) {
	int collaborateurId=0;
	   for(Collaborateur collaborateur : this.getAllCollaborateur()){
		   if(collaborateur.getEmail().equals(email)){
			   collaborateurId = collaborateur.getId();
			   return collaborateurId;
		   }
	   }
	   return collaborateurId;
	}
	
}
