package vermeg.move.spring.entity;
import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Table_Itineraire")
public class Itineraire implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int id;
	 @Column(name="Billet")
	 private String billet;
	 @Column(name="Mode_Transport")
	 @Enumerated(EnumType.STRING)
	 private ModeTransport modeTransport;
	 @Column(name="Heure_Depart",columnDefinition = "TIME")
	 private LocalTime  heureDepart;
	 @Column(name="Heure_Arrivee",columnDefinition = "TIME")
	 private LocalTime  heureArrivee;
	 @Column(name="Point_Depart")
	 private String pointDepart;
	 @Column(name="Point_Arrivee")
	 private String pointArrivee;
	 
	 /* Association */
	 
	 @ManyToOne
	 private Deplacement deplacement;

	 /* Constructeurs */
	 
	    public Itineraire() {
				super();
			}
	 
		public Itineraire( String billet, ModeTransport modeTransport, LocalTime heureDepart, LocalTime heureArrivee,
			String pointDepart, String pointArrivee, Deplacement deplacement) {
		super();
		this.billet = billet;
		this.modeTransport = modeTransport;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.pointDepart = pointDepart;
		this.pointArrivee = pointArrivee;
		this.deplacement = deplacement;
	    }

	 /* Getters et Setters */
	 
	    public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBillet() {
			return billet;
		}
		public void setBillet(String billet) {
			this.billet = billet;
		}
		public ModeTransport getModeTransport() {
			return modeTransport;
		}
		public void setModeTransport(ModeTransport modeTransport) {
			this.modeTransport = modeTransport;
		}
		public LocalTime getHeureDepart() {
			return heureDepart;
		}
		public void setHeureDepart(LocalTime heureDepart) {
			this.heureDepart = heureDepart;
		}
		public LocalTime getHeureArrivee() {
			return heureArrivee;
		}
		public void setHeureArrivee(LocalTime heureArrivee) {
			this.heureArrivee = heureArrivee;
		}
		public String getPointDepart() {
			return pointDepart;
		}
		public void setPointDepart(String pointDepart) {
			this.pointDepart = pointDepart;
		}
		public String getPointArrivee() {
			return pointArrivee;
		}
		public void setPointArrivee(String pointArrivee) {
			this.pointArrivee = pointArrivee;
		}
        @JsonIgnore
		public Deplacement getDeplacement() {
			return deplacement;
		}
		public void setDeplacement(Deplacement deplacement) {
			this.deplacement = deplacement;
		}

		/* TO-STRING AND HASHCODE AND EQUALS*/
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.id;
			return result;
		}

		@Override
		public String toString() {
			return "Itineraire [id=" + id + ", billet=" + billet + ", modeTransport=" + modeTransport + ", heureDepart="
					+ heureDepart + ", heureArrivee=" + heureArrivee + ", pointDepart=" + pointDepart
					+ ", pointArrivee=" + pointArrivee + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Itineraire other = (Itineraire) obj;
			if (this.id != other.id)
				return false;
			return true;
		}
	 
}