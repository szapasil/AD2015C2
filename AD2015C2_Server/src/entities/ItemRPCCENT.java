package entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="itemsRProvCC")
public class ItemRPCCENT { 
	
	@EmbeddedId
	private ItemRPCCENTpk id;
	@Column
	private int cantidad;
	
	public ItemRPCCENTpk getId() {
		return id;
	}
	
	public void setId(ItemRPCCENTpk id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public ItemRPCCENT() {
		
	}
	
	public ItemRPCCENT(RemitoProvCCENT remito, RodamientoENT rodamiento, int cantidad) {
		super();
		this.id = new ItemRPCCENTpk(remito, rodamiento);
		this.cantidad = cantidad;
	}
	
}
	
