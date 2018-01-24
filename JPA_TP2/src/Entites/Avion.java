package Entites;

import javax.persistence.*;

@Entity(name="AVIONS")
@Table(schema="TP1", name="AVIONS")
public class Avion {

	@Id
	Integer NumAv;
	
	@Column(name="NomAv")
	String nom;
	
	@Column(name="CapAv")
	Integer capacité;
	
	@Column(name="VilleAv")
	String ville;
	
	
}
