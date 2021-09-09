package vermeg.move.spring.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name="Table_Deplacement")
@JsonIgnoreProperties(value = "collaborateur", allowSetters = true)
public class Deplacement implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int id;
	 @Column(name="Ville_Depart")
	 private String villeDepart;
	 @Column(name="Ville_Arrivee")
	 private String villeArrivee;
	 @Column(name="Date_Depart", columnDefinition = "DATE")
	 private LocalDate  dateDepart;
	 @Column(name="Date_Retour", columnDefinition = "DATE")
	 private LocalDate  dateRetour;
	 @Column(name="Etat")
	 @Enumerated(EnumType.STRING)
	 private Etat etat;
	 @Column(name="Notice")
	 @Lob
	 private String notice;
	 @Column(name="Remuneration")
	 private   int remuneration ;
	 
	 /* Association */
	 
	 @ManyToOne
	 private Collaborateur collaborateur;
	 @OneToMany(cascade = CascadeType.REMOVE, mappedBy="deplacement",fetch = FetchType.LAZY)
	 private Set<Itineraire> itineraire;

	 /* Constructeurs */
	 
     public Deplacement() {
			super();
	 }
	 
	 public Deplacement( String villeDepart, String villeArrivee, LocalDate dateDepart, LocalDate dateRetour
				, String notice, Collaborateur collaborateur) {
			super();
			this.villeDepart = villeDepart;
			this.villeArrivee = villeArrivee;
			this.dateDepart = dateDepart;
			this.dateRetour = dateRetour;
			this.etat = Etat.draft;
			this.notice = notice;
			this.collaborateur = collaborateur;
	 }
		
	 /* Getters et Setters */
	 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getVilleDepart() {
			return villeDepart;
		}
		public void setVilleDepart(String villeDepart) {
			this.villeDepart = villeDepart;
		}
		public String getVilleArrivee() {
			return villeArrivee;
		}
		public void setVilleArrivee(String villeArrivee) {
			this.villeArrivee = villeArrivee;
		}
		public LocalDate getDateDepart() {
			return dateDepart;
		}
		public void setDateDepart(LocalDate dateDepart) {
			this.dateDepart = dateDepart;
		}
		public LocalDate getDateRetour() {
			return dateRetour;
		}
		public void setDateRetour(LocalDate dateRetour) {
			this.dateRetour = dateRetour;
		}
		public Etat getEtat() {
			return etat;
		}
		public void setEtat(Etat etat) {
			this.etat = etat;
		}
		public String getNotice() {
			return notice;
		}
		public void setNotice(String notice) {
			this.notice = notice;
		}
		public int getRemuneration() {
			return remuneration;
		}
		public void setRemuneration(int remuneration) {
			this.remuneration = remuneration;
		}
		public Collaborateur getCollaborateur() {
			return collaborateur;
		}
		public void setCollaborateur(Collaborateur collaborateur) {
			this.collaborateur = collaborateur;
		}
		@JsonIgnore
		public Set<Itineraire> getItineraire() {
			return itineraire;
		}
		public void setItineraire(Set<Itineraire> itineraire) {
			this.itineraire = itineraire;
		}

		/* TO-STRING AND HASHCODE AND EQUALS*/
		
		@Override
		public String toString() {
			return "Deplacement [id=" + id + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee
					+ ", dateDepart=" + dateDepart + ", dateRetour=" + dateRetour + ", etat=" + etat + ", notice="
					+ notice + ", remuneration=" + remuneration + "]";
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
			Deplacement other = (Deplacement) obj;
			if (this.id != other.id)
				return false;
			return true;
		}
		
		/* METHODS*/
		
		public  static  int differenceBetweenDate(LocalDate dateDepart,LocalDate dateRetour,Collaborateur collaborateur){
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateDepart,dateRetour);
			return (int) (noOfDaysBetween*collaborateur.getRole().getFrais());
		}
		
}
