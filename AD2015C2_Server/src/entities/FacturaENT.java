package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import dominio.Cliente;
import dominio.ItemFactura;

@Entity
@Table(name="facturas")
public class FacturaENT {
@Id
@Column (name="numero_factura")
private int numero;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="numero_sucursal", nullable = false)	
private OVENT ov;
@Column
	private String tipo;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cuilCliente")
private ClienteENT cliente;
@Column
private Date fechaEmision;
@Column
private float subtotal;
@Column
private float impuestos;
@Column
private float total;
@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.factura")
private List<ItemFacturaENT> items;
public FacturaENT() {
	super();
	// TODO Auto-generated constructor stub
}
public FacturaENT(int numero, OVENT ov, String tipo, ClienteENT cliente,
		Date fechaEmision, float subtotal, float impuestos, float total,
		List<ItemFacturaENT> items) {
	super();
	this.numero = numero;
	this.ov = ov;
	this.tipo = tipo;
	this.cliente = cliente;
	this.fechaEmision = fechaEmision;
	this.subtotal = subtotal;
	this.impuestos = impuestos;
	this.total = total;
	this.items = items;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public OVENT getOv() {
	return ov;
}
public void setOv(OVENT ov) {
	this.ov = ov;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public ClienteENT getCliente() {
	return cliente;
}
public void setCliente(ClienteENT cliente) {
	this.cliente = cliente;
}
public Date getFechaEmision() {
	return fechaEmision;
}
public void setFechaEmision(Date fechaEmision) {
	this.fechaEmision = fechaEmision;
}
public float getSubtotal() {
	return subtotal;
}
public void setSubtotal(float subtotal) {
	this.subtotal = subtotal;
}
public float getImpuestos() {
	return impuestos;
}
public void setImpuestos(float impuestos) {
	this.impuestos = impuestos;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public List<ItemFacturaENT> getItems() {
	return items;
}
public void setItems(List<ItemFacturaENT> items) {
	this.items = items;
}

}
