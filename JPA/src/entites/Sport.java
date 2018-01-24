package entites;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Sport {

	@Id
	private Integer id;
	private String nom;
	@ManyToMany(mappedBy="Sports")
	private Set<Personne> personnes;
	
	public Set<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public Sport(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
