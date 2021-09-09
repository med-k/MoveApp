package vermeg.move.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vermeg.move.spring.entity.Itineraire;


@Repository
public interface ItineraireRepository extends CrudRepository<Itineraire,Integer>{

	@Query(value ="SELECT * FROM Table_Itinerair u WHERE u.deplacement_id = ?1 " , nativeQuery =true)
	List<Itineraire> retrieveAllItineraireByDeplacement(int id);
}
