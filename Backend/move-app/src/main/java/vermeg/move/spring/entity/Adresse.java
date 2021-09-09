package vermeg.move.spring.entity;
import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class Adresse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="Ville")
	private String ville;
	@Column(name="Rue")
	private String rue;
	@Column(name="Code_Postale")
	private String codePostale;
	@Column(name="Numero_Rue")
	private int numRue;

	  /* Constructeurs */
	public Adresse() {
		super();
	}
	
	
	public Adresse(String ville, String rue, String codePostale, int numRue) {
		super();
		this.ville = ville;
		this.rue = rue;
		this.codePostale = codePostale;
		this.numRue = numRue;
	}
	 
	  /* Getters et Setters */
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	
}
