package vermeg.move.spring.service;
import java.util.Arrays;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import vermeg.move.spring.entity.User;
import javax.ws.rs.core.Response;

@Service
public class KeycloackService {
    final String serverUrl = "http://localhost:8080/auth";
    final String realm ="vermeg";
    final String username = "idm-admin";
    final String password = "idm-admin";
    final String clientId = "idm-client";
    
    public String createUser(User user){
    	
     // Define user
   	 UserRepresentation keycloackUser = new UserRepresentation();
   	 keycloackUser.setEnabled(true);
   	 keycloackUser.setUsername(user.getUsername());
   	 keycloackUser.setFirstName(user.getFirstName());
   	 keycloackUser.setLastName(user.getLastName());
   	 keycloackUser.setEmail(user.getEmail());
   	 
   	 // Get realm
     Keycloak  keycloak =  KeycloakBuilder.builder()
    		              .serverUrl(serverUrl)
    		              .grantType(OAuth2Constants.PASSWORD)
    		              .realm("master")
                          .clientId("admin-cli")
                          .username("admin")
                          .password("admin")
                          .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
     
     keycloak.tokenManager().getAccessToken();
   	 RealmResource realmResource = keycloak.realm(realm);
   	 UsersResource usersRessource = realmResource.users();
   	 
   	 // Create user
   	 Response response = usersRessource.create(keycloackUser);
   	 String userId = CreatedResponseUtil.getCreatedId(response);
   	 UserResource userResource = usersRessource.get(userId);
   	 
   	 // Define password credential
   	 CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(user.getPassword());
        
     // Set password credential
     userResource.resetPassword(passwordCred);
        
     // Get realm role
     RoleRepresentation RealmRole = realmResource.roles().get(user.getRole()).toRepresentation();
        
     // Assign realm role 
     userResource.roles().realmLevel().add(Arrays.asList(RealmRole));  
     return userId;
    }
    
    public String deleteUser(String email){
        Keycloak  keycloak =  KeycloakBuilder.builder()
	              .serverUrl(serverUrl)
	              .grantType(OAuth2Constants.PASSWORD)
	              .realm("master")
                  .clientId("admin-cli")
                  .username("admin")
                  .password("admin")
                  .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
        
        keycloak.tokenManager().getAccessToken();
      	RealmResource realmResource = keycloak.realm(realm);
      	UsersResource usersRessource = realmResource.users();
      	
      	
      	for(UserRepresentation user : usersRessource.list()){
      		if(user.getEmail().equals(email)){
      			String userId = user.getId();
      			UserResource userResource = usersRessource.get(userId);
      	      	userResource.remove();
      			return userId;
      		}
      	}		
      	return null;
    }
    
}
