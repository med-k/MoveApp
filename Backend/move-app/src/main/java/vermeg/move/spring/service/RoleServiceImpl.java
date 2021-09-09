package vermeg.move.spring.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vermeg.move.spring.entity.Role;
import vermeg.move.spring.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAllRole() {
		List<Role> ListRoles = new ArrayList<Role>();
		roleRepository.findAll().forEach(x -> ListRoles.add(x));
		return ListRoles;
	}
	
	@Override
	public Role getRoleById(int id) {
		return roleRepository.findById(id).get();
	}
	
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public Role editRole(Role role,int id) {
		Role existingRole = roleRepository.findById(id).get();
		if(role.getRole() != null){
			existingRole.setRole(role.getRole());
		}
		if(role.getFrais() != 0){
			existingRole.setFrais(role.getFrais());
		}
		return roleRepository.save(existingRole);
	}
	
	@Override
	public void deleteRoleById(int id) {
		roleRepository.deleteById(id);	
	}

}
