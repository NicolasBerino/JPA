package entites;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Commande {

	@Id
	private Integer id;
	
	@ManyToMany
	private Set<Article> lignesCommande;
	
	//Uni plusieurs
	@ManyToOne
	@JoinColumn(name="Id_Client")
	private Personne personne;

	public Commande(Integer id, Set<Article> lignesCommande, Personne personne) {
		super();
		this.id = id;
		this.lignesCommande = lignesCommande;
		this.personne = personne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Article> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(Set<Article> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}

