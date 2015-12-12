package entities;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsSC")
public class ItemSolCompraENT  {
	
	@EmbeddedId
	private ItemSolCompraENTpk id; 
@Column
	private int cantidad;
@Column
	private float precio;
public ItemSolCompraENT() {
	super();
	// TODO Auto-generated constructor stub
}
public ItemSolCompraENT(ItemSolCompraENTpk id, int cantidad, float precio) {
	super();
	this.id = id;
	this.cantidad = cantidad;
	this.precio = precio;
}
public ItemSolCompraENT(RodamientoENT rodamiento, int cantidad2, float precio2) {
	ItemSolCompraENTpk id = new ItemSolCompraENTpk();
	id.setRodamiento(rodamiento);
	id.setSolicitudCompra(solicitudCompra);
}
public ItemSolCompraENTpk getId() {
	return id;
}
public void setId(ItemSolCompraENTpk id) {
	this.id = id;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}
	

}
