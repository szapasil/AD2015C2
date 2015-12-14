package entities;

import javax.persistence.*;

import dominio.ItemOC;
import dominio.Rodamiento;

@Entity
@Table(name="itemsLP")
public class ItemOCENT {
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="codRodamiento")
//	private RodamientoENT rodamiento;
	@EmbeddedId
	private ItemOCENTpk id;
	private int cantidad;
	private float precio;
	
	public ItemOCENT(OrdenDeCompraENT oc, RodamientoENT rodamiento, int cantidad, float precio) {
		super();
//		this.rodamiento = rodamiento;
		this.id = new ItemOCENTpk(oc, rodamiento);
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
//	public RodamientoENT getRodamiento() {
//		return rodamiento;
//	}
	
//	public void setRodamiento(RodamientoENT rodamiento) {
//		this.rodamiento = rodamiento;
//	}
	
	public ItemOCENTpk getId() {
		return id;
	}

	public void setId(ItemOCENTpk id) {
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

	public static ItemOC toDOM(ItemOCENT iocENT) {
		ItemOC ioc = new ItemOC();
		ioc.setRodamiento(Rodamiento.toDOM(iocENT.getId().getRodamiento()));
		ioc.setCantidad(iocENT.getCantidad());
		ioc.setPrecio(iocENT.getPrecio());
		return ioc;
	}
	
}
