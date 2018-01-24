package entites;

import javax.persistence.*;

@Entity
public class Article {

	@Id
	private Integer id;
	private String nom;
	private Double prix;

	
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
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Article(Integer id, String nom, Double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	
		
}
