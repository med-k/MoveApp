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

import vermeg.move.spring.entity.Passeport;
import vermeg.move.spring.service.PasseportServiceImpl;

@RestController
public class PasseportControlImpl {
	
	@Autowired
	PasseportServiceImpl passeportServiceImpl;
	
	/*------Get------*/
	
	@RolesAllowed({ "admin","agent"})
	@GetMapping("/passeport")
	@ResponseBody
	public List<Passeport> getAllPasseport(@RequestHeader String Authorization){
		return passeportServiceImpl.getAllPasseport();
	}
	
	@RolesAllowed({ "admin", "director","manager","agent","collaborater"})
	@GetMapping("/passeport/collaborateur/{id}")
	@ResponseBody
	public List<Passeport> getAllPasseportByCollaborateur(@RequestHeader String Authorization,@PathVariable("id") int id){
		return passeportServiceImpl.getAllPasseportByCollaborateur(id);
	}
	
	@RolesAllowed({ "admin", "director","manager","agent","collaborater"})
	@GetMapping("/passeport/{id}")
	@ResponseBody
	public Passeport getPasseport(@RequestHeader String Authorization,@PathVariable("id") int id){
		return passeportServiceImpl.getPasseport(id);
	}
	
	/*------POST------*/
	
	@RolesAllowed({ "admin","agent"})
	@PostMapping("/passeport")
	@ResponseBody
	public Passeport addPasseport(@RequestHeader String Authorization,@RequestBody Passeport passeport){
		return passeportServiceImpl.addPasseport(passeport);
	}
	
	/*------PUT------*/
	
	@RolesAllowed({ "admin","agent"})
	@PutMapping("/passeport/{id}")
	@ResponseBody
	public Passeport editPasseport(@RequestHeader String Authorization,@PathVariable("id") int id,@RequestBody Passeport passeport){
		return passeportServiceImpl.editPasseport(passeport,id);
	}
	
	/*------DELETE------*/
	
	@RolesAllowed({ "admin","agent"})
	@DeleteMapping("/passeport")
	@ResponseBody
	public void deletePasseportById(@RequestHeader String Authorization,int id){
		passeportServiceImpl.deletePasseportById(id);
	}
}
