package Entites;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity (name="DEFCLASSES")
@Table  (schema="TP1", name="DEFCLASSES")
public class defClasse {
	
	@EmbeddedId
	private IdDefClasses iddefClas;

	@MapsId("idVol")
	@ManyToOne
	@JoinColumn(name="NUMVOL")
	private Vol vol;
	
	@Column(name="CoeffPlace", precision = 3, scale = 2)
	BigDecimal coeffPlace;
	
	@Column(name="CoeffPrix", precision = 3, scale = 2)
	BigDecimal coeffPrix;
		
}

