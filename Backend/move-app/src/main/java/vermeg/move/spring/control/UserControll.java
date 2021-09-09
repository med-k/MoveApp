package vermeg.move.spring.control;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermeg.move.spring.entity.User;
import vermeg.move.spring.service.KeycloackService;

@RestController
public class UserControll {
	
	@Autowired
	KeycloackService keycloackService;
	
	@RolesAllowed( "admin")
	@PostMapping("/user")
	@ResponseBody
	public String addUser(@RequestBody User user){
		return keycloackService.createUser(user);
	}
	
	@RolesAllowed( "admin")
	@DeleteMapping("/user")
	@ResponseBody
	public String deleteUser(@RequestBody String email){
		return keycloackService.deleteUser(email);
	}
	
}
