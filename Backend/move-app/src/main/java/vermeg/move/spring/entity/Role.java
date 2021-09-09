package vermeg.move.spring.entity;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Table_Role")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="Frais_Par_Jours")
	private int frais ;
	@Column(name="Role")
	private String role;

	
	 /* Association */
	
	@OneToMany(mappedBy="role")
	private Set<Collaborateur> collaborateur;
	
	 /* Constructeurs */

	public Role() {
		super();
	}
	
	public Role(int frais, String role ) {
		super();
		this.frais = frais;
		this.role = role;
		
	}
	
	 /* Getters et Setters */

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrais() {
		return frais;
	}
	public void setFrais(int frais) {
		this.frais = frais;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@JsonIgnore
	public Set<Collaborateur> getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Set<Collaborateur> collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	/* TO-STRING AND HASHCODE AND EQUALS*/

	@Override
	public String toString() {
		return "Role [id=" + this.id + ", frais=" + frais + ", role=" + this.role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
	
}