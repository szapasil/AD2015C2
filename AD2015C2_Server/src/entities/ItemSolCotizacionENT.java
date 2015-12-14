package entities;

import javax.persistence.*;

@Entity
@Table(name="itemsSolicitudCotizacion")
public class ItemSolCotizacionENT { 
	
	@EmbeddedId
	private ItemSolCotizacionENTpk id;
	@Column
	private int cantidad;
	
	public ItemSolCotizacionENTpk getId() {
		return id;
	}
	
	public void setId(ItemSolCotizacionENTpk id) {
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
	}
	
	public ItemSolCotizacionENT(SolicitudCotizacionENT solCotiz, RodamientoENT rodamiento, int cantidad) {
		super();
		this.id = new ItemSolCotizacionENTpk(solCotiz, rodamiento);
		this.cantidad = cantidad;
	}
	
}
	