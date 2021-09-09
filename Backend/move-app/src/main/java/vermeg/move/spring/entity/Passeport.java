package vermeg.move.spring.entity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="Table_Passeport")
@JsonIgnoreProperties(value = "collaborateur", allowSetters = true)
public class Passeport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Numero",unique=true)
	private String numero;
	@Column(name="Pays")
	private String pays;
	@Column(name="Date_Expiration", columnDefinition = "DATE")
	private LocalDate dateExpiration;
	
	 /* Association */
	
	@ManyToOne
	private Collaborateur collaborateur;

	 /* Constructeurs */
	
	public Passeport() {
		super();
	}
	
	public Passeport( String numero, String pays, LocalDate dateExpiration, Collaborateur collaborateur) {
		super();
		this.numero = numero;
		this.pays = pays;
		this.dateExpiration = dateExpiration;
		this.collaborateur = collaborateur;
	}
	
	 /* Getters et Setters */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/* TO-STRING AND HASHCODE AND EQUALS*/
	
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
		Passeport other = (Passeport) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
	
}
