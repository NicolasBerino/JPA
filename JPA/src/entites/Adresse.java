package entites;

import java.io.Serializable;

import javax.persistence.*;
@Embeddable
public class Adresse implements Serializable{

	@Id
	@Column(name="ID")
	private static final long serialVersionUID = 1L;
	
	public Adresse(String rue, String codepostal, String ville) {
		super();
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
	}

	@Column(name="RUE")
	private String rue;
	
	@Column(name="CODEPOSTAL")
	private String codepostal;	
	
	@Column(name="VILLE")
	private String ville;
	
	public Adresse(){}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
