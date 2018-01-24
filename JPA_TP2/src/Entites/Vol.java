package Entites;

import java.sql.Date;

import javax.persistence.*;

@Entity(name="VOLS")
@Table (schema="TP1", name="VOLS")
public class Vol {

	@Id
	String NumVol;
	
	@Column(name="VilleD")
	String villeDepart;
	
	@Column(name="VilleA")
	String villeArrive;
	
	@Column(name="DateD")
	Date dateDepart;
	
	@Column(name="DateA")
	Date dateArrive;
	
	
	@ManyToOne
	@JoinColumn(name="NumPil")
	Pilote pilote;

	
	@ManyToOne
	@JoinColumn(name="NumAv")
	Avion avion;
	
	@Column(name="CoutVol")
	Integer prix;
	
}
