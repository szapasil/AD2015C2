package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.OrdenDePedidoENT;
import entities.SolicitudDeCompraENT;

public class SolicitudDeCompra {

	private int numero;
	private Date fecha;
	private float precioTotal;
	private List<OrdenDePedido> ordenesDePedido;
	private List<ItemSC> items;

	public SolicitudDeCompra(int numero, Date fecha, float precioTotal, List<OrdenDePedido> ordenesDePedido) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.ordenesDePedido = ordenesDePedido;
		this.items = new ArrayList<ItemSC>();
		persistirse();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<OrdenDePedido> getOrdenesDePedido() {
		return ordenesDePedido;
	}

	public void setOrdenesDePedido(List<OrdenDePedido> ordenesDePedido) {
		this.ordenesDePedido = ordenesDePedido;
	}

	public List<ItemSC> getItems() {
		return items;
	}

	public void setItems(List<ItemSC> items) {
		this.items = items;
	}
	
	public void persistirse() {
		SolicitudDeCompraENT scENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(scENT);
	}

	public SolicitudDeCompraENT toENT() {
		List<OrdenDePedidoENT> opsENT = new ArrayList<OrdenDePedidoENT>();
		for(OrdenDePedido op:ordenesDePedido)
			opsENT.add(op.toENT());
		return new SolicitudDeCompraENT(numero, fecha, precioTotal,opsENT);
	}
}
