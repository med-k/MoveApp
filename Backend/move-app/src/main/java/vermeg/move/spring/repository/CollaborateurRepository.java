package vermeg.move.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vermeg.move.spring.entity.Collaborateur;

@Repository
public interface CollaborateurRepository extends CrudRepository<Collaborateur,Integer> {

}
