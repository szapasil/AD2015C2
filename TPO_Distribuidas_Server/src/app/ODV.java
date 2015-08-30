package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import remoto.IODV;
import xml.SolicitudCotizacionXmlDao;
import dominio.Cliente;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.OrdenDeCompra;
import dominio.OrdenDePedido;
import dominio.Remito;
import dominio.SolicitudCotizacion;
import dominio.DAO.ClienteDAO;

@Entity
@Table(name="odvs")
public class ODV extends UnicastRemoteObject implements IODV {

	private static final long serialVersionUID = 1L;
	@Id
	private String sucursal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idSC")
	private List<SolicitudCotizacion> solicitudesCotizacion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idCotizacion")
	private List<Cotizacion> cotizaciones;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	private List<Cliente> clientes;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idFactura")
	private List<Factura> facturas;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idOP")
	private List<OrdenDePedido> ordenesPedido;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idOC")
	private List<OrdenDeCompra> ordenesCompra;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idRemito")
	private List<Remito> remitos;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="listaComparativa")
	private List<Remito> listaComparativa;
	
	//MR2106 - Elimino el singleton ya que (a diferencia de la CPR) sí pueden existir varias instancias de ODVs
	
	private	static ODV instanciaODV;
	
	public static ODV getInstancia() throws RemoteException{
		if (instanciaODV == null)
			instanciaODV = new ODV();
		return instanciaODV;
	}

		
	public ODV() throws RemoteException{
		super();
	}
	
	public ODV(String sucursal,	List<SolicitudCotizacion> solicitudesCotizacion,List<Cotizacion> cotizaciones,
		List<Cliente> clientes,	List<Factura> facturas, List<OrdenDePedido> ordenesPedido, 
		List<OrdenDeCompra> ordenesCompra, List<Remito> remitos) throws RemoteException	{
		super();
		this.sucursal = sucursal;
		this.solicitudesCotizacion  = new ArrayList<SolicitudCotizacion>();
		this.cotizaciones = new ArrayList<Cotizacion>();
		this.clientes = new ArrayList<Cliente>();
		this.facturas = new ArrayList<Factura>();
		this.ordenesPedido = new ArrayList<OrdenDePedido>();
		this.ordenesCompra = new ArrayList<OrdenDeCompra>();
		this.remitos = new ArrayList<Remito>();
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
	
	public void setSolicitudesCotizacion(List<SolicitudCotizacion> solicitudesCotizacion) {
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
	

	public List<Remito> getListaComparativa() {
		return listaComparativa;
	}

	public void setListaComparativa(List<Remito> listaComparativa) {
		this.listaComparativa = listaComparativa;
	}

	//****************************************** METODOS DE LA INTERFAZ **********************************************//

		// Punto 1
		@Override
	public void recibirSolicitudCotizacion(String cuil, String archivo)	throws RemoteException {
		Cliente cli = buscarCliente(cuil);
		if(cli!=null)
			cargarSolicitudCotizacion(archivo);
	}
		
	public Cliente buscarCliente(String cuil) {
		for(Cliente c:clientes)
			if(c.getCuil().equals(cuil))
				return c;		
		return Cliente.buscarClienteDAO(cuil);
	}
	
	@Override
	public void cargarSolicitudCotizacion(String archivo) throws RemoteException {
		SolicitudCotizacionXmlDao.getInstancia().guardarEnBD(archivo);
	}


	// Punto 6 - ABM de Clientes 
	// MR0306 - Cambio "cargarCliente" por "altaCliente" para no confundirlo con "cargarClientes" y que coincida con ABM
	@Override
	public void altaCliente(String cuil, String razonSocial, Date fechaRegistro, 
			float monto, String direccion) throws RemoteException {
		Cliente c = new Cliente();
		c.setCuil(cuil);
		c.setRazonSocial(razonSocial);
		c.setFechaRegistrado(fechaRegistro);
		c.setMontoTotal(monto);
		c.setDireccion(direccion);
		ClienteDAO.getInstancia().cargarCliente(c);
	}

	@Override
	public void bajaCliente(String cuil) throws RemoteException {
		ClienteDAO.getInstancia().bajaCliente(cuil);
	}

	@Override
	public void modificarCliente(String cuil, String razsoc, float monto,String direccion) throws RemoteException{
		ClienteDAO.getInstancia().modificarCliente(cuil, razsoc, monto, direccion);
	}

	@Override
	public void cargarClientes(String archivo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
