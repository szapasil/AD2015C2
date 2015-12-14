package entities;

import javax.persistence.*;

@Entity
@Table(name="itemsFactura")
public class ItemFacturaENT {
	@EmbeddedId
	private ItemFacturaENTpk id;
	@Column
	private int cantidad;
	@Column
	private float precioUnitario;
	public ItemFacturaENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemFacturaENT(ItemFacturaENTpk id, int cantidad,
			float precioUnitario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	public ItemFacturaENTpk getId() {
		return id;
	}
	public void setId(ItemFacturaENTpk id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
