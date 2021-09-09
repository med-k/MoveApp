package vermeg.move.spring.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vermeg.move.spring.entity.Collaborateur;
import vermeg.move.spring.entity.Deplacement;
import vermeg.move.spring.entity.Etat;
import vermeg.move.spring.repository.CollaborateurRepository;
import vermeg.move.spring.repository.DeplacementRepository;

@Service
public class DeplacementServiceImpl implements DeplacementService{

	@Autowired
	DeplacementRepository deplacementRepository;
	
	@Autowired
	CollaborateurRepository collaborateurRepository;

	@Override
	public List<Deplacement> getAllDeplacement() {
		List<Deplacement> listDeplacement = new ArrayList<Deplacement>();
		deplacementRepository.findAll().forEach(x -> listDeplacement.add(x));
		return listDeplacement;
	}
	

	@Override
	public List<Deplacement> getAllDeplacmentByDirector(int id) {
		Collaborateur director = collaborateurRepository.findById(id).get();
		Set<Collaborateur> listCollaborateur = director.getEquipe();
		List<Deplacement> allDeplacement = new ArrayList<Deplacement>();
		listCollaborateur.forEach(x -> {
			allDeplacement.addAll(this.getAllDeplacementByCollaborateur(x.getId()));
			allDeplacement.addAll( this.getAllDeplacementByManager(x.getId()));
		});
		return allDeplacement;
	}

	@Override
	public List<Deplacement> getAllDeplacementByManager(int id) {
		Collaborateur manager = collaborateurRepository.findById(id).get();
		Set<Collaborateur> listCollaborateur = manager.getEquipe();
		List<Deplacement> allDeplacement = new ArrayList<Deplacement>();
		listCollaborateur.forEach(x -> {
			List<Deplacement> deplacements = this.getAllDeplacementByCollaborateur(x.getId());
			allDeplacement.addAll(deplacements);
		});
		return allDeplacement;	
	}

	@Override
	public List<Deplacement> getAllDeplacementByCollaborateur(int id) {
		List<Deplacement> allDeplacement = new ArrayList<Deplacement>();
		 deplacementRepository.findAll().forEach(x ->{
			if(x.getCollaborateur().getId() == id){
				allDeplacement.add(x);
			}
		});;
		return allDeplacement;
	}

	@Override
	public Deplacement getDeplacementById(int id) {
		return deplacementRepository.findById(id).get();
	}

	@Override
	public Deplacement addDeplacment(Deplacement deplacement) {
		Collaborateur collaborateur = collaborateurRepository.findById(deplacement.getCollaborateur().getId()).get();
		int frais = Deplacement.differenceBetweenDate(deplacement.getDateDepart(),deplacement.getDateRetour(),collaborateur);
		deplacement.setRemuneration(frais);
		return deplacementRepository.save(deplacement);
	}
	
	@Override
	public Deplacement setDeplacementEtatById(int id,String etat) {
		Deplacement deplacement = deplacementRepository.findById(id).get();
		deplacement.setEtat(Etat.valueOf(etat));
		deplacementRepository.save(deplacement);
		return deplacement;
	}

	@Override
	public void deleteDeplacementById(int id) {
		deplacementRepository.deleteById(id);
		
	}
	
}
