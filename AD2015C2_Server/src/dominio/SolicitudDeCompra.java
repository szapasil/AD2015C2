package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ProveedorDAO;
import dao.SolicitudDeCompraDAO;
import entities.OrdenDePedidoENT;
import entities.ProveedorENT;
import entities.SolicitudDeCompraENT;

public class SolicitudDeCompra {

	private int numero;
	private Date fechaEmision;
	private float precioTotal;
	private List<OrdenDePedido> ordenesDePedido;
	private String estado;
	private Date fechaEntregaEstimada;
	private List<ItemSolCompra> items;

	public SolicitudDeCompra(int numero, Date fechaEmision, float precioTotal, List<OrdenDePedido> ordenesDePedido, String estado) {
		super();
		this.numero = numero;
		this.fechaEmision = fechaEmision;
		this.precioTotal = precioTotal;
		this.ordenesDePedido = ordenesDePedido;
		this.estado = estado;
		this.items = new ArrayList<ItemSolCompra>();
		persistirse();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public List<ItemSolCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemSolCompra> items) {
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
		return new SolicitudDeCompraENT(numero, fechaEmision, precioTotal,opsENT, estado);
	}

	public static List<SolicitudDeCompra> buscarSCPendentesDAO() {
		List<SolicitudDeCompra> pendientes = new ArrayList<SolicitudDeCompra>();
		for(SolicitudDeCompraENT sc:SolicitudDeCompraDAO.getInstancia().obtenerPendientes())
			pendientes.add(toDOM(sc));
		return pendientes;
	}

	private static SolicitudDeCompra toDOM(SolicitudDeCompraENT scENT) {
		List<OrdenDePedido> ops = new ArrayList<OrdenDePedido>();
		for(OrdenDePedidoENT opENT:scENT.getOrdenesDePedido())
			ops.add(OrdenDePedido.toDOM(opENT));
		return new SolicitudDeCompra(scENT.getNumero(), scENT.getFecha(), scENT.getPrecioTotal(), ops, scENT.getEstado());
	}
	
}
