package vermeg.move.spring.control;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermeg.move.spring.entity.Role;
import vermeg.move.spring.service.RoleServiceImpl;

@RestController
public class RoleControlImpl {
	
	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	/*------Get------*/
	
	@RolesAllowed( "admin")
	@GetMapping("/role")
	@ResponseBody
	public List<Role> getAllRole(@RequestHeader String Authorization){
		return roleServiceImpl.getAllRole();
	}
	
	@RolesAllowed( "admin")
	@GetMapping("/role/{id}")
	@ResponseBody
	public Role getRoleById(@RequestHeader String Authorization,@PathVariable("id") int id){
		return roleServiceImpl.getRoleById(id);
	}
	
	/*------POST------*/
	
	@RolesAllowed( "admin")
	@PostMapping("/role")
	@ResponseBody
	public Role addRole(@RequestHeader String Authorization,@RequestBody Role role){
		return roleServiceImpl.addRole(role);
	}
	
	/*------PUT------*/
	
	@RolesAllowed( "admin")
	@PutMapping("/role/{id}")
	@ResponseBody
	public Role editRole(@RequestHeader String Authorization,@RequestBody Role role,@PathVariable("id") int id){
		return roleServiceImpl.editRole(role,id);
	}
	
	/*------DELETE------*/
	
	@RolesAllowed( "admin")
	@DeleteMapping("/role/{id}")
	@ResponseBody
	public void deleteRoleById(@RequestHeader String Authorization,@PathVariable("id") int id){
		roleServiceImpl.deleteRoleById(id);
	}
}
