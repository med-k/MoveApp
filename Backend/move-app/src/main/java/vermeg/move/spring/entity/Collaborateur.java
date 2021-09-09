package vermeg.move.spring.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="Table_COLLABORATEUR")
@JsonIgnoreProperties(value = {"superviseur","role"}, allowSetters = true)
public class Collaborateur implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;
  @Column(name="Nom")
  private String nom;
  @Column(name="Prenom")
  private String prenom;
  @Column(name="Email",unique=true)
  private String email;
  @Column(name="Numero_de_téléphone")
  private String numTel;
  @Column(name="Numero_de_CIN",unique=true)
  private String cin;
  @Embedded
  private Adresse adresse;
  
  /* Association */


  @ManyToOne
  @JoinColumn(name="superviseur")
  private Collaborateur superviseur;
  
  @OneToMany(mappedBy="superviseur",cascade= CascadeType.ALL)
  private Set<Collaborateur> equipe = new HashSet<Collaborateur>(); 
  
  @OneToMany(mappedBy="collaborateur")
  private Set<Passeport> passeport;
  
  @OneToMany(mappedBy="collaborateur")
  private Set<Deplacement> deplacement;
  
 
  @ManyToOne
  private Role role;

  /* Constructeurs */
  
    public Collaborateur() {
		super();
	}
   
	public Collaborateur(String nom, String prenom, String email, String numTel, String cin, Adresse adresse,Collaborateur superviseur,Role role) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numTel = numTel;
	this.cin = cin;
	this.adresse = adresse;
	this.role = role;
	this.superviseur = superviseur;
    }
	
  /* Getters et Setters */
  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
    public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@JsonIgnore
	public Set<Passeport> getPasseport() {
		return passeport;
	}
	public void setPasseport(Set<Passeport> passeport) {
		this.passeport = passeport;
	}
	@JsonIgnore
	public Set<Deplacement> getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(Set<Deplacement> deplacement) {
		this.deplacement = deplacement;
	}
	public Collaborateur getSuperviseur() {
		return superviseur;
	}
	public void setSuperviseur(Collaborateur superviseur) {
		this.superviseur = superviseur;
	}
	@JsonIgnore
	public Set<Collaborateur> getEquipe() {
		return equipe;
	}
	public void setEquipe(Set<Collaborateur> equipe) {
		this.equipe = equipe;
	}

	/* TO-STRING AND HASHCODE AND EQUALS*/
	
	@Override
	public String toString() {
		return "Collaborateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numTel="
				+ numTel + ", cin=" + cin + ", adresse=" + adresse + "]";
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
		Collaborateur other = (Collaborateur) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
	
	/* METHODS*/
	
	public void addSupervisorEquipe(){
		this.getEquipe().add(this);
	}
	
	public void removeSupervisorEquipe(){
		this.getSuperviseur().getEquipe().remove(this);
	}
		
}
