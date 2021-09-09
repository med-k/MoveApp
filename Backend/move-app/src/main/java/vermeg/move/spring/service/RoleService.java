package vermeg.move.spring.service;
import java.util.List;
import vermeg.move.spring.entity.Role;

public interface RoleService {
	   public List<Role> getAllRole();
	   public Role getRoleById(int id);
       public Role addRole(Role role);
       public Role editRole(Role role,int id);
       public void deleteRoleById(int id);
}
