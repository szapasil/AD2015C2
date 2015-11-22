package app;

import interfaz.IOV;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.Cliente;
import dominio.CondPago;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.OrdenDeCompra;
import dominio.OrdenDePedido;
import dominio.Proveedor;
import dominio.Remito;
import dominio.Rodamiento;
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
		this.solicitudesCotizacion = new ArrayList<SolicitudCotizacion>();
		this.cotizaciones = new ArrayList<Cotizacion>();
		this.clientes = new ArrayList<Cliente>();
		this.facturas = new ArrayList<Factura>();
		this.ordenesPedido = new ArrayList<OrdenDePedido>();
		this.ordenesCompra = new ArrayList<OrdenDeCompra>();
		this.remitos =  new ArrayList<Remito>();
		this.condicionesPago = new ArrayList<CondPago>();
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
	
	public void altaCliente(String cuil, String razonSocial, String direccion) throws RemoteException {
		
		Cliente c = buscarCliente(cuil);	
		if(c==null){
		 c = new Cliente(cuil, razonSocial, direccion);
		//clientes.add(c);
		}
		else
			System.out.print("Ya existe un Cliente con ese cuil");
			
			
	}
	
	public Cliente buscarCliente(String cuil) throws RemoteException{
		/*
		 * for(Cliente c:clientes)
			if(c.getCuil().equals(cuil))
				return c;				
		*/
		return Cliente.buscarClienteDAO(cuil);
	}

	
		
	
	public void bajaCliente(String cuil) throws RemoteException {
		Cliente c = buscarCliente(cuil);	
		if(c!=null){
				c.baja();
		}
		else
			System.out.print("No existe un Cliente con ese cuil");
	}


	public void modificarCliente(String cuil, String razonSocial, String direccion) throws RemoteException{
		Cliente c = buscarCliente(cuil);	
		if(c!=null){
				c.modificar(razonSocial,direccion);
		}
		else
			System.out.print("No existe un Cliente con ese cuil");
	}

	
	
		
}
