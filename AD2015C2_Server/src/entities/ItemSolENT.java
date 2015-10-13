package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import hbt.PersistentObject;


@Entity
@Table(name="itemsSOL")
public class ItemSolENT extends PersistentObject { 

	int cantidad;
	String codRodamiento;
	

	public ItemSolENT( ) {

	}
	
	public ItemSolENT(int cantidad, String codRodamiento) {
		super();
		this.cantidad = cantidad;
		this.codRodamiento = codRodamiento;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getCodRodamiento() {
		return codRodamiento;
	}


	public void setCodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}
	
	
	
	
	
	
}
