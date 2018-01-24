package entites;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table (name="Personne")
public class Personne{
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOMS")
	private String nom;
	
	@ElementCollection
	@Column(name="PRENOMS")
	private List<String> prenoms;
	
	@ElementCollection
	@CollectionTable(name= "Adresse", joinColumns=@JoinColumn(name="ID_PERS"))
	@MapKeyColumn(name="TypeAdr")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<TypeAdresse,Adresse> adresses;
	
	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;
	
	
	@Column(name="CIVILITE")
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	
	@ManyToMany
	@JoinTable(name="Personne_Sport",
		joinColumns=@JoinColumn(name="ID_Personne"),
		inverseJoinColumns=@JoinColumn(name="Id_Sport"))
	private Set<Sport> Sports;
	
	@OneToMany(mappedBy="personne")
	private Set<Commande> commandes;
	
	public Set<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}


	public Set<Sport> getSports() {
		return Sports;
	}


	public void setSports(Set<Sport> sports) {
		Sports = sports;
	}


	public Personne(Integer id, String nom, List<String> prenoms, Map<TypeAdresse, Adresse> adresses, Date dateNaissance,
			Civilite civilite) {
		this.id=id;
		this.nom = nom;
		this.prenoms = prenoms;
		this.adresses = adresses;
		this.dateNaissance = dateNaissance;
		this.civilite = civilite;
	}

	
	public Personne (){}
	
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
	public List<String> getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(List<String> prenoms) {
		this.prenoms = prenoms;
	}
	public Map<TypeAdresse, Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(Map<TypeAdresse, Adresse> adresses) {
		this.adresses = adresses;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	
}
