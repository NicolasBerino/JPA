package Entites;

import javax.persistence.*;

@Entity(name="PILOTES")
@Table(schema="TP1", name="PILOTES")
public class Pilote {
	
	@Id
	Integer NumPil;
	
	@Column(name="NomPil")
	String NomPil;
	
	@Column(name="NaisPil", scale = 0, precision = 4)
	Integer dateNaissance;
	
	@Column(name="VillePil")
	String ville;
	
}