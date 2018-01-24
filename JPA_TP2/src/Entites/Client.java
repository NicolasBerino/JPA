package Entites;

import javax.persistence.*;

@Entity(name="CLIENTS")
@Table (schema="TP1", name="CLIENTS")
public class Client {

	@Id
	Integer NumCl;
	
	@Column(name="NomCl")
	String nom;
	
	@Column(name="NumRueCl")
	Integer numRue;
	
	@Column(name="NomRueCl")
	String nomRue;
	
	@Column(name="CodePosteCl")
	int codePostal;
	
	@Column(name="VilleCl")
	String ville;
	
}