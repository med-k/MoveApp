package vermeg.move.spring.service;
import java.util.List;
import vermeg.move.spring.entity.Deplacement;

public interface DeplacementService {
          public List<Deplacement> getAllDeplacement();
          public List<Deplacement> getAllDeplacmentByDirector(int id);
          public List<Deplacement> getAllDeplacementByManager(int id);
          public List<Deplacement> getAllDeplacementByCollaborateur(int id);
          public Deplacement getDeplacementById(int id);
          public Deplacement addDeplacment(Deplacement deplacement);
          public Deplacement setDeplacementEtatById(int id,String etat);
          public void deleteDeplacementById(int id);
}
