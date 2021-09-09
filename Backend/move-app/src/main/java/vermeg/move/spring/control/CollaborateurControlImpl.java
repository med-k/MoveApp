package vermeg.move.spring.control;
import java.util.Collection;
import java.util.Set;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vermeg.move.spring.entity.Collaborateur;
import vermeg.move.spring.service.CollaborateurServiceImpl;


@RestController
public class CollaborateurControlImpl {
	
	@Autowired
	CollaborateurServiceImpl collaborateurServiceImpl;
	

	
	/*------Get------*/
	
	@RolesAllowed({ "admin", "director","manager"})
	@GetMapping("/collaborateur")
	@ResponseBody
	public Set<Collaborateur> getAllCollaborateur(){
		KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority role :  authorities){
			if(role.getAuthority().equals("ROLE_admin")){
				return collaborateurServiceImpl.getAllCollaborateur();
			}
			else{
				SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
				AccessToken token= account.getKeycloakSecurityContext().getToken();
				if(role.getAuthority().equals("ROLE_director")){
					return collaborateurServiceImpl.getAllCollaborateurByDirector(collaborateurServiceImpl.getCollaborateurIdByEmail(token.getEmail()));
				}
				else {
					return collaborateurServiceImpl.getAllCollaborateurByManager(collaborateurServiceImpl.getCollaborateurIdByEmail(token.getEmail()));
				}		
			}
			}
		
		return null;
	}
	
	@RolesAllowed({ "admin", "director","manager","agent","collaborater" })
	@GetMapping("/collaborateur/{id}")
	@ResponseBody
	public Collaborateur getCollaborateurById(@PathVariable("id") int id){
		return collaborateurServiceImpl.getCollaborateurById(id);
	}
		
	/*------POST------*/
	
	@RolesAllowed( "admin")
	@PostMapping("/collaborateur")
	@ResponseBody
	public Collaborateur addCollaborateur(@RequestBody Collaborateur collaborateur){
		return collaborateurServiceImpl.addCollaborateur(collaborateur);
	}
	
	/*------PUT------*/

	@RolesAllowed( "admin")
	@PutMapping("/collaborateur/{id}")
	@ResponseBody
	public Collaborateur modifierCollaborateur(@RequestBody Collaborateur collaborateur,@PathVariable("id") int id){
		return collaborateurServiceImpl.modifierCollaborateur(collaborateur,id);
	}
	
	/*------DELETE------*/
	
	@RolesAllowed( "admin")
	@DeleteMapping("/collaborateur/{id}")
	@ResponseBody
	public void deleteCollaborateurById(@PathVariable("id") int id){
		collaborateurServiceImpl.deleteCollaborateurById(id);
	}
	
}
