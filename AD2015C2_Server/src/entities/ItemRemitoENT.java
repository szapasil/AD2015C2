package entities;

import javax.persistence.*;

@Entity
@Table (name="itemRemitos")
public class ItemRemitoENT {
	@EmbeddedId
private ItemRemitoENTpk id;
	@Column
	private int cantidad;
	public ItemRemitoENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemRemitoENT(ItemRemitoENTpk id, int cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}
	public ItemRemitoENTpk getId() {
		return id;
	}
	public void setId(ItemRemitoENTpk id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
