package vermeg.move.spring.control;
import java.util.Collection;
import java.util.List;
import javax.annotation.security.RolesAllowed;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermeg.move.spring.entity.Deplacement;
import vermeg.move.spring.service.CollaborateurServiceImpl;
import vermeg.move.spring.service.DeplacementServiceImpl;

@RestController
public class DeplacementControlImpl {

	@Autowired
	DeplacementServiceImpl deplacementServiceImpl;
	
	@Autowired
	CollaborateurServiceImpl collaborateurServiceImpl;
	
	/*------Get------*/
	
	@RolesAllowed({ "admin", "director","manager","agent" })
	@GetMapping("/deplacement")
	@ResponseBody
	public List<Deplacement> getAllDeplacement(@RequestHeader String Authorization){
		KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority role :  authorities){
			if(role.getAuthority().equals("ROLE_admin") || role.getAuthority().equals("ROLE_agent")){
				return deplacementServiceImpl.getAllDeplacement();
			}
			else{
				SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
				AccessToken token= account.getKeycloakSecurityContext().getToken();
				if(role.getAuthority().equals("ROLE_director")){
					return deplacementServiceImpl.getAllDeplacmentByDirector(collaborateurServiceImpl.getCollaborateurIdByEmail(token.getEmail()));
				}
				else {
					return deplacementServiceImpl.getAllDeplacementByManager(collaborateurServiceImpl.getCollaborateurIdByEmail(token.getEmail()));
				}		
			}
			}
		
		return null;
	}
	
	@RolesAllowed({"director","manager","collaborater" })
	@GetMapping("/deplacement/collaborateur/{id}")
	@ResponseBody
	public List<Deplacement> getAllDeplacementByCollaborateur(@PathVariable("id") int id){
		return deplacementServiceImpl.getAllDeplacementByCollaborateur(id);
	}
	
	@RolesAllowed({ "admin", "director","manager","collaborater","agent" })
	@GetMapping("/deplacement/{id}")
	@ResponseBody
	public Deplacement getDeplacementById(@PathVariable("id") int id){
		return deplacementServiceImpl.getDeplacementById(id);
	}
	
	/*------POST------*/
	
	@RolesAllowed({ "admin", "director","manager","agent" })
	@PostMapping("/deplacement")
	@ResponseBody
	public Deplacement addDeplacment(@RequestBody Deplacement deplacement){
		return deplacementServiceImpl.addDeplacment(deplacement);
	}
	
	/*------PUT------*/
	
	@RolesAllowed({ "admin", "director","manager","agent" })
	@PutMapping("/deplacement/{id}/settat")
	@ResponseBody
	public Deplacement setDeplacementEnCoursById(@PathVariable("id") int id,@RequestBody String etat){
		return deplacementServiceImpl.setDeplacementEtatById(id,etat);
	}

	/*------DELETE------*/
	
	@RolesAllowed("admin")
	@DeleteMapping("/deplacement/{id}")
	@ResponseBody
	public void deleteDeplacementById(@PathVariable("id") int id){
		deplacementServiceImpl.deleteDeplacementById(id);
	}
	
}