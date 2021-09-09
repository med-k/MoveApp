package vermeg.move.spring.service;
import java.util.Set;

import vermeg.move.spring.entity.Collaborateur;

public interface CollaborateurService {
	     public Set<Collaborateur> getAllCollaborateur();
	     public Set<Collaborateur> getAllCollaborateurByManager(int id);
	     public Set<Collaborateur> getAllCollaborateurByDirector(int id);
	     public Collaborateur getCollaborateurById(int id);
	     public int getCollaborateurIdByEmail(String email);
	     public Collaborateur addCollaborateur(Collaborateur collaborateur);
	     public Collaborateur modifierCollaborateur(Collaborateur collaborateur,int id);
	     public void deleteCollaborateurById(int id);
}
