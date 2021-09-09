package vermeg.move.spring.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vermeg.move.spring.entity.Passeport;

@Repository
public interface PasseportRepository extends CrudRepository<Passeport,Integer>{

	@Query(value ="SELECT * FROM table_passeport u where u.collaborateur_id=?1",nativeQuery = true)
	List<Passeport> retrievePasseportByCollaborateur(int id);
}
