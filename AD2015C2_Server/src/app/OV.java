package app;

import interfaz.IOV;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dominio.Cliente;
import dominio.CondPago;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.OrdenDeCompra;
import dominio.OrdenDePedido;
import dominio.Remito;
import dominio.SolicitudCotizacion;
import dao.ClienteDAO;

public class OV extends UnicastRemoteObject implements IOV {

	private static final long serialVersionUID = 1L;
	private String sucursal;
	private List<SolicitudCotizacion> solicitudesCotizacion;
	private List<Cotizacion> cotizaciones;
	private List<Cliente> clientes;
	private List<Factura> facturas;
	private List<OrdenDePedido> ordenesPedido;
	private List<OrdenDeCompra> ordenesCompra;
	private List<Remito> remitos;
	private List<CondPago> condicionesPago;
	
	public OV(String sucursal, List<SolicitudCotizacion> solicitudesCotizacion,
			List<Cotizacion> cotizaciones, List<Cliente> clientes,
			List<Factura> facturas, List<OrdenDePedido> ordenesPedido,
			List<OrdenDeCompra> ordenesCompra, List<Remito> remitos,
			List<CondPago> condicionesPago) throws RemoteException {
		super();
		this.sucursal = sucursal;
		this.solicitudesCotizacion = solicitudesCotizacion;
		this.cotizaciones = cotizaciones;
		this.clientes = clientes;
		this.facturas = facturas;
		this.ordenesPedido = ordenesPedido;
		this.ordenesCompra = ordenesCompra;
		this.remitos = remitos;
		this.condicionesPago = condicionesPago;
	}

	public OV() throws RemoteException {
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public List<SolicitudCotizacion> getSolicitudesCotizacion() {
		return solicitudesCotizacion;
	}

	public void setSolicitudesCotizacion(
			List<SolicitudCotizacion> solicitudesCotizacion) {
		this.solicitudesCotizacion = solicitudesCotizacion;
	}

	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}

	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<OrdenDePedido> getOrdenesPedido() {
		return ordenesPedido;
	}

	public void setOrdenesPedido(List<OrdenDePedido> ordenesPedido) {
		this.ordenesPedido = ordenesPedido;
	}

	public List<OrdenDeCompra> getOrdenesCompra() {
		return ordenesCompra;
	}

	public void setOrdenesCompra(List<OrdenDeCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<Remito> remitos) {
		this.remitos = remitos;
	}

	public List<CondPago> getCondicionesPago() {
		return condicionesPago;
	}

	public void setCondicionPago(List<CondPago> condicionesPago) {
		this.condicionesPago = condicionesPago;
	}
	
	
	
	/* ABM Clientes - Gaston 04/10 */
	
	public void altaCliente(String cuil, String razonSocial, java.sql.Date fechaRegistro, 
			CondPago condPago, String direccion) throws RemoteException {
		Cliente c = new Cliente();
		c.setCuil(cuil);
		c.setRazonSocial(razonSocial);
		c.setFechaRegistro(fechaRegistro);
		c.setDireccion(direccion);
		c.setCondicionesPago(condPago);
		c.setSolicitudesCotizacion(null);
		
		ClienteDAO.getInstancia().crearCliente(c);
		
			
	}
	
	
	
		
}
