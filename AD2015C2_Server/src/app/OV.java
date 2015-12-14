package app;

import hbt.HibernateDAO;
import interfaz.IOV;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.OVDAO;
import delegado.BusinessDelegateCC;
import dominio.Cliente;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.ItemCotizacion;
import dominio.ItemOP;
import dominio.ItemSolCompra;
import dominio.ItemSolCotizacion;
import dominio.RemitoCCOV;
import dominio.RemitoTransporte;
import dominio.SolicitudDeCompra;
import dominio.OrdenDePedido;
import dominio.Remito;
import dominio.SolicitudCotizacion;
import dto.ItemLCDTO;
import entities.OVENT;

public class OV extends UnicastRemoteObject implements IOV {

	private static final long serialVersionUID = 1L;
	private int numeroSucursal;
	private String nombreSucursal;
	private List<SolicitudCotizacion> solicitudesCotizacion;
	private List<Cotizacion> cotizaciones;
	private List<Cliente> clientes;
	private List<Factura> facturas;
	private List<OrdenDePedido> ordenesPedido;
	private List<SolicitudDeCompra> solicitudesCompra;
	private List<Remito> remitos;
	
	public int getNumeroSucursal() {
		return numeroSucursal;
	}

	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
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

	public List<SolicitudDeCompra> getOrdenesCompra() {
		return solicitudesCompra;
	}

	public void setOrdenesCompra(List<SolicitudDeCompra> solicitudesCompra) {
		this.solicitudesCompra = solicitudesCompra;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<Remito> remitos) {
		this.remitos = remitos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OV(int numeroSucursal, String nombreSucursal,
			List<SolicitudCotizacion> solicitudesCotizacion,
			List<Cotizacion> cotizaciones, List<Cliente> clientes,
			List<Factura> facturas, List<OrdenDePedido> ordenesPedido,
			List<SolicitudDeCompra> solicitudesCompra, List<Remito> remitos) throws RemoteException {
		super();
		this.numeroSucursal = numeroSucursal;
		this.nombreSucursal = nombreSucursal;
		this.solicitudesCotizacion = solicitudesCotizacion;
		this.cotizaciones = cotizaciones;
		this.clientes = clientes;
		this.facturas = facturas;
		this.ordenesPedido = ordenesPedido;
		this.solicitudesCompra = solicitudesCompra;
		this.remitos = remitos;
		persistirse();
	}

	public OV() throws RemoteException {
		super();
	}


	public OV(int arg0, RMIClientSocketFactory arg1, RMIServerSocketFactory arg2)
			throws RemoteException {
		super(arg0, arg1, arg2);
	}

	public OV(int arg0) throws RemoteException {
		super(arg0);
	}

	// SILVIO INICIO >>>
	public OV(int numeroSucursal, String nombreSucursal) throws RemoteException {
		this.numeroSucursal = numeroSucursal;		
		this.nombreSucursal = nombreSucursal;		
		this.solicitudesCotizacion = new ArrayList<SolicitudCotizacion>();
		this.cotizaciones = new ArrayList<Cotizacion>();
		this.clientes = new ArrayList<Cliente>();
		this.facturas = new ArrayList<Factura>();
		this.ordenesPedido = new ArrayList<OrdenDePedido>();
		this.solicitudesCompra = new ArrayList<SolicitudDeCompra>();
		this.remitos =  new ArrayList<Remito>();
		persistirse();
	}
	
	private void persistirse() {
		OVENT ovENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(ovENT);
	}

	public void altaSolicitudCotizacion(int numero, Date fechaEnviada, 
			String clienteCuit) throws RemoteException {
		Cliente c = Cliente.buscarClienteDAO(clienteCuit);
		SolicitudCotizacion sc = new SolicitudCotizacion(numero, fechaEnviada, c);  
		this.solicitudesCotizacion.add(sc);
	}

	public SolicitudCotizacion altaSolicitudCotizacionFromClient(int numero, Date fechaEnviada, 
			String clienteCuit) throws RemoteException {
		Cliente c = Cliente.buscarClienteDAO(clienteCuit);
		SolicitudCotizacion sc = new SolicitudCotizacion();
		sc.setCliente(c);
		sc.setNumero(numero);
		sc.setFechaEnviada(fechaEnviada);  
		return sc;
	}
	
	public SolicitudCotizacion buscarSolicitudCotizacion(int i) {
		for (SolicitudCotizacion sc : solicitudesCotizacion) {
			if (sc.getNumero()==i) {
				return sc;
			}
		}
		return null;
	}

	public Cotizacion buscarCotizacion(int i) {
		for (Cotizacion c : cotizaciones) {
			if (c.getNumero()==i) {
				return c;
			}
		}
		return null;
	}
	
	// SILVIO FIN <<<		

	// PUNTO 1 - COTIZAR SOLICITUD DE RODAMIENTO
	
	public void cotizarSolicitudCotizacion(String nombreArchivo) throws Exception {
		SolicitudCotizacion sc = altaSolicitudCotizacion(nombreArchivo);
		cotizarSolicitud(sc);
	}

	public SolicitudCotizacion altaSolicitudCotizacion(String nombreArchivo) throws Exception {
		SolicitudCotizacion sc = SolicitudCotizacion.fromXML(nombreArchivo, this);
		sc.persistirse();
		solicitudesCotizacion.add(sc);
		return sc;
	}
	
	public void cotizarSolicitud(SolicitudCotizacion sc) throws RemoteException {
		BusinessDelegateCC bdCC = new BusinessDelegateCC();
		bdCC.LookupServiceCC();
		Cotizacion cotizacion = new Cotizacion();
		for(ItemSolCotizacion isc:sc.getItems()){
			ItemLCDTO ilcDTO = bdCC.publicarLC(isc.getRodamiento().getCodRodamiento());
			ItemCotizacion ic = new ItemCotizacion();
			ic.CotizarItem(ilcDTO,isc);
			cotizacion.getItems().add(ic);
		}
		cotizacion.generarCotizacion(sc);
		cotizacion.persistirse();
		cotizaciones.add(cotizacion);
		cotizacion.toXML();
	}

	// PUNTO 2 - VENTA DE RODAMIENTOS
	public void ventaRodamientos(String nombreArchivo) throws Exception {
		OrdenDePedido op = altaOrdenDePedido(nombreArchivo);
		tratarOrdenDePedido(op);
	}

	public OrdenDePedido altaOrdenDePedido(String nombreArchivo) throws Exception {
		OrdenDePedido op = OrdenDePedido.fromXML(nombreArchivo, this);
		op.persistirse();
		ordenesPedido.add(op);
		return op;
	}

	private void tratarOrdenDePedido(OrdenDePedido op) throws RemoteException {
		float total = 0;
		boolean cotizarNuevamente = false;
		List<ItemOP> itemsACotizar = new ArrayList<ItemOP>();
		SolicitudDeCompra sc = new SolicitudDeCompra();
		for(ItemOP iop:op.getItems()){
			if(op.getFechaEnviada().before(iop.getCotizacion().getFechaExpiracion())){
				ItemSolCompra isc = new ItemSolCompra();
				isc.generarItem(iop);
				sc.getItems().add(isc);
				total = total + (iop.getPrecio()*iop.getCantidad());
			}
			else{
				cotizarNuevamente = true;
				itemsACotizar.add(iop);
			}
		}
		sc.generarSolicitudCompra(sc,op,this);
		sc.setPrecioTotal(total);
		sc.persistirse();
		solicitudesCompra.add(sc);
		sc.toXML();
		if(cotizarNuevamente)
			cotizarNuevamente(op,itemsACotizar);
	}
	
	public void cotizarNuevamente(OrdenDePedido op, List<ItemOP> itemsACotizar) throws RemoteException {
		SolicitudCotizacion sc = new SolicitudCotizacion();
		sc.generarSolicitudDesdeOP(op, itemsACotizar);
		sc.persistirse();
		solicitudesCotizacion.add(sc);
		cotizarSolicitud(sc);
	}
	
	// PUNTO 3 - ENTREGA DE PEDIDOS
	public void entregaDePedidos(String nombreArchivo) throws Exception {
		RemitoCCOV rccov = RemitoCCOV.fromXML(nombreArchivo);
		RemitoTransporte rt = new RemitoTransporte();
		//por cada SolcitudDeCompra
		for(SolicitudDeCompra sc:rccov.getSolicitudesDeCompra()){
			Remito remitoCliente = new Remito();
			OrdenDePedido op = sc.getOrdenDePedido();
			//por cada ItemSolCompra
			for(ItemOP iop:sc.getOrdenDePedido().getItems()){
				remitoCliente.agregarItem(op,iop,rccov);
			}
			remitoCliente.setCliente(sc.getOrdenDePedido().getCliente());
			Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
			remitoCliente.setFechaEmision(fechaHoy);
			Factura factura = new Factura();
			factura.generarFactura(sc,remitoCliente);
			remitoCliente.setFactura(factura);
			remitoCliente.toXML();
			factura.toXML();
			rt.agregarPedidoCliente(remitoCliente);
		}
		rt.toXML();
	}
		
	// PUNTO 4 - ABM CLIENTE
	public void altaCliente(String razonSocial, String direccion, String cuil,
			String condicionIVA, String condicionPago, float descuento, int nroSucursal) throws Exception {
		Cliente c = Cliente.buscarClienteDAO(cuil);
		if(c==null){
//		if(!existeCliente(cuil)){
//			Cliente c = new Cliente(this, razonSocial, direccion, cuil,	condicionIVA, condicionPago, descuento);
			c = new Cliente(buscarOVDAO(nroSucursal), razonSocial, direccion, cuil,	condicionIVA, condicionPago, descuento);
//			clientes.add(c);
		}
		else
			throw new Exception ("Ya existe un Cliente con ese cuil");
	}

	public boolean existeCliente(String cuil) throws Exception{
		for(Cliente c:clientes)
			if(c.getCuil().compareTo(cuil)==0)
				return true;				
		Cliente c = Cliente.buscarClienteDAO(cuil);
		if (c == null) {
			return false;
		}
		return true;
	}
	
	public Cliente buscarCliente(String cuil) throws Exception{
		for(Cliente c:clientes)
			if(c.getCuil().compareTo(cuil)==0)
				return c;				
		Cliente c = Cliente.buscarClienteDAO(cuil);
		if (c == null) {
			throw (new Exception ("Cliente no Existe"));
		}
		return c;
	}	
	
	public void bajaCliente(String cuil) throws Exception {
		Cliente c = buscarCliente(cuil);	
		if(c!=null){
				c.baja();
		}
		else
			System.out.print("No existe un Cliente con ese cuil");
	}

	public void modificarCliente(String cuil, String razonSocial, String direccion) throws Exception{
		Cliente c = buscarCliente(cuil);	
		if(c!=null){
				c.modificar(razonSocial,direccion);
		}
		else
			System.out.print("No existe un Cliente con ese cuil");
	}
	
	//OPERACIONES PROPIAS DE OV
	public static OV buscarOVDAO(int nroSucursal) throws RemoteException {
		OVENT ovENT = OVDAO.getInstancia().BuscarOV(nroSucursal);
		if(ovENT!=null)
			return toDOM(ovENT);
		return null;
	}
	
	public OVENT toENT() {
		return new OVENT(this.numeroSucursal, this.nombreSucursal);
		
	}
	
	static public OV toDOM(OVENT ov) throws RemoteException {
		return new OV(ov.getNumeroSucursal(), ov.getNombreSucursal());
	}

}