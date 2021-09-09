package vermeg.move.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vermeg.move.spring.entity.Role;

@Repository
public interface RoleRepository  extends CrudRepository<Role,Integer>{

}
