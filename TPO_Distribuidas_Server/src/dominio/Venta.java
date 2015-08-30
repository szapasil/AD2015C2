package dominio;

import hbt.PersistentObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitudesDeCompra")
public class Venta extends PersistentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="factura")
	private Factura factura;
	private PoliticaDescuento politicaDescuento;
	
	public Venta(Factura factura, PoliticaDescuento politicaDescuento) {
		super();
		this.factura = factura;
		this.politicaDescuento = politicaDescuento;
	}
	
	public Factura getFactura() {
		return factura;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public PoliticaDescuento getPoliticaDescuento() {
		return politicaDescuento;
	}
	
	public void setPoliticaDescuento(PoliticaDescuento politicaDescuento) {
		this.politicaDescuento = politicaDescuento;
	}
	
}
