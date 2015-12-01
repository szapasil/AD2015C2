package entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="itemsRCCOC")
public class ItemRCCOVENT { 
	
	@EmbeddedId
	private ItemRCCOVENTpk id;
	@Column
	private int cantidad;
	
	public ItemRCCOVENTpk getId() {
		return id;
	}
	
	public void setId(ItemRCCOVENTpk id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public ItemRCCOVENT() {
		
	}
	
	public ItemRCCOVENT(RemitoCCOVENT remito, RodamientoENT rodamiento, int cantidad) {
		super();
		this.id = new ItemRCCOVENTpk(remito, rodamiento);
		this.cantidad = cantidad;
	}
	
}
