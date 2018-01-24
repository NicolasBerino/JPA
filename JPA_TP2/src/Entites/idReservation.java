package Entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class idReservation implements Serializable{

	int NumCL;
	IdDefClasses idDef;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumCL;
		result = prime * result + ((idDef == null) ? 0 : idDef.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		idReservation other = (idReservation) obj;
		if (NumCL != other.NumCL)
			return false;
		if (idDef == null) {
			if (other.idDef != null)
				return false;
		} else if (!idDef.equals(other.idDef))
			return false;
		return true;
	}


}	
