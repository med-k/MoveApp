package vermeg.move.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vermeg.move.spring.entity.Deplacement;



@Repository
public interface DeplacementRepository extends CrudRepository<Deplacement,Integer>{
		
}
