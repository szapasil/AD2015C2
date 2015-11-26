package entities;

import javax.persistence.*;

import dominio.ItemSolCotizacion;
import hbt.PersistentObject;

@Entity
@Table(name="itemsSOL")
public class ItemSolCotizacionENT { 
	@EmbeddedId
	private ItemSolENTpk id;
	@Column
	private int cantidad;
	public ItemSolENTpk getId() {
		return id;
	}
	public void setId(ItemSolENTpk id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ItemSolCotizacionENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemSolCotizacionENT(SolicitudCotizacionENT solCotiz, RodamientoENT rodamiento, int cantidad) {
		super();
		this.id = new ItemSolENTpk(solCotiz, rodamiento);
		this.cantidad = cantidad;
	}
	
}
	