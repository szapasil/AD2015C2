package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import app.OV;
import dao.ProveedorDAO;
import dao.SolicitudDeCompraDAO;
import entities.ItemLPENT;
import entities.ItemSolCompraENT;
import entities.OVENT;
import entities.OrdenDePedidoENT;
import entities.ProveedorENT;
import entities.SolicitudDeCompraENT;

public class SolicitudDeCompra {

	private int numero;
	private OV ov;
	private Date fechaEmision;
	private float precioTotal;
	private List<OrdenDePedido> ordenesDePedido;
	private String estado;
	private Date fechaEntregaEstimada;
	private List<ItemSolCompra> items;

	public SolicitudDeCompra() {
		
	}
	
	public SolicitudDeCompra(int numero, OV ov, Date fechaEmision, float precioTotal, String estado, Date fechaEntregaEstimada) {
		super();
		this.numero = numero;
		this.ov = ov;
		this.fechaEmision = fechaEmision;
		this.precioTotal = precioTotal;
		this.ordenesDePedido = new ArrayList<OrdenDePedido>();
		this.estado = estado;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.items = new ArrayList<ItemSolCompra>();
		persistirse();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public OV getOv() {
		return ov;
	}

	public void setOv(OV ov) {
		this.ov = ov;
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
		List<ItemSolCompraENT> itemsENT = new ArrayList<ItemSolCompraENT>();
		SolicitudDeCompraENT scENT = new SolicitudDeCompraENT(numero, ov.toENT(), fechaEmision, fechaEntregaEstimada, precioTotal, estado);
		for(OrdenDePedido op:ordenesDePedido)
			opsENT.add(op.toENT());
		scENT.setOrdenesDePedido(opsENT);
		for(ItemSolCompra item:items) 
			itemsENT.add(item.toENT(scENT));
		scENT.setItems(itemsENT);
		return new SolicitudDeCompraENT();
	}

	public static List<SolicitudDeCompra> buscarSCPendentesDAO() {
		List<SolicitudDeCompra> pendientes = new ArrayList<SolicitudDeCompra>();
		for(SolicitudDeCompraENT sc:SolicitudDeCompraDAO.getInstancia().obtenerPendientes())
			pendientes.add(toDOM(sc));
		return pendientes;
	}

	public static SolicitudDeCompra toDOM(SolicitudDeCompraENT scENT) {
		List<OrdenDePedido> ops = new ArrayList<OrdenDePedido>();
		List<ItemSolCompra> items = new ArrayList<ItemSolCompra>();
		SolicitudDeCompra sc = new SolicitudDeCompra();
		sc.setEstado(scENT.getEstado());
		sc.setFechaEmision(scENT.getFechaEmision());
		sc.setFechaEntregaEstimada(scENT.getFechaEntregaEstimada());
		for(ItemSolCompraENT iscENT:scENT.getItems())
			items.add(ItemSolCompra.toDOM(iscENT));
		sc.setItems(items);
		sc.setNumero(scENT.getNumero());
		for(OrdenDePedidoENT opENT:scENT.getOrdenesDePedido())
			ops.add(OrdenDePedido.toDOM(opENT));
		sc.setOrdenesDePedido(ops);
		sc.setOv(scENT.getOv().toDOM());
		sc.setPrecioTotal(scENT.getPrecioTotal());
		return sc;
	}
	
}
