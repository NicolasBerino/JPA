package Entites;

import javax.persistence.*;

@Entity(name="Reservations")
@Table (schema="TP1",name="Reservations")
public class Reservation {
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="NumCl",
				column=@Column(name="NUMCL")),
		@AttributeOverride(name="NumVol",
			column=@Column(name="NUMVOL")),
		@AttributeOverride(name="classe",
			column=@Column(name="CLASSE")),
	})
	private idReservation idRes;

	
	
	@MapsId("numCl")
	@ManyToOne
	@JoinColumn(name="NUMCL")
	private Client cli;
	
	@MapsId("idDef")
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="NUMVOL",
					referencedColumnName="NUMVOL"),
		@JoinColumn(name="CLASSE",
			referencedColumnName="Classe")
	}) 
	private defClasse defC;
	
	
	@Column(name="NbPlaces")
	int nbPlace;
}
