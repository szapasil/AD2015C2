package entities;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="CONDPAGO")
public class CondPagoENT extends PersistentObject {

	
	int cantDias;
	float recargo;
	


	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	public float getRecargo() {
		return recargo;
	}
	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}
	
			
	
	
	
}
