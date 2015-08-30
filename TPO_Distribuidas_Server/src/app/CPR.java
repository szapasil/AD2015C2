package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xml.ListaProveedoresXmlDao;

import dominio.OrdenDeCompra;
import dominio.Proveedor;
import dominio.Rodamiento;
import dominio.SolicitudDeCompra;
import dominio.DAO.ListaComparativaDAO;
import dominio.DAO.ProveedorDAO;

public class CPR extends UnicastRemoteObject implements remoto.ICPR{
	// Agregar todo el HQL - MRECA	

	private static final long serialVersionUID = 1L;
	
	private List<ODV> odvs;
	private List<Rodamiento> rodamientos;
	private List<Proveedor> proveedores;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private float porcentajeGanancia;
	
	private static CPR instancia;
	
	public static CPR getInstancia() throws RemoteException 
	{
		if (instancia== null)
			instancia = new CPR();
		return instancia;
	}

	protected CPR() throws RemoteException 
	{
		super();

		odvs = new ArrayList<ODV>();
		rodamientos = new ArrayList<Rodamiento>();
		proveedores = new ArrayList<Proveedor>();
		ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		solicitudesDeCompra = new ArrayList<SolicitudDeCompra>();
		porcentajeGanancia = 0;
	}

		
	public List<ODV> getOdvs() {
		return odvs;
	}

	public void setOdvs(List<ODV> odvs) {
		this.odvs = odvs;
	}

	public List<Rodamiento> getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(List<Rodamiento> rodamientos) {
		this.rodamientos = rodamientos;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public List<OrdenDeCompra> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(List<OrdenDeCompra> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public List<SolicitudDeCompra> getSolicitudesDeCompra() {
		return solicitudesDeCompra;
	}

	public void setSolicitudesDeCompra(List<SolicitudDeCompra> solicitudesDeCompra) {
		this.solicitudesDeCompra = solicitudesDeCompra;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	
	//****************************************** METODOS DE LA INTERFAZ **********************************************//

	// Punto 1 - ABM Proveedores
	@Override
	public void altaProveedor(String razonSocial, String direccion,	String cuil, String condicionesPago, float descuento,
			String condicionesCompra) throws RemoteException {
		Proveedor prov = buscarProveedor(cuil);
		if(prov==null) {
			prov = new Proveedor(razonSocial, direccion, cuil, condicionesPago, descuento, condicionesCompra);
			prov.setEstado("activo");
			proveedores.add(prov);
			ProveedorDAO.getInstancia().cargarProveedor(prov);
		}
	}

	@Override
	public void bajaProveedor(String cuil) throws RemoteException{
		Proveedor prov = buscarProveedor(cuil);
		if(prov!=null){
			prov.setEstado("inactivo");
			ProveedorDAO.getInstancia().bajaProveedor(cuil);
		}
	}

	@Override
	public void modificarProveedor(String razonSocial, String direccion, String cuil, String condicionesPago,
			float descuento, String condicionesCompra, String estado) throws RemoteException{
		Proveedor prov = buscarProveedor(cuil);
		if(prov!=null){
			prov.setRazonSocial(razonSocial);
			prov.setDireccion(direccion);
			prov.setCondicionesPago(condicionesPago);
			prov.setDescuento(descuento);
			prov.setCondicionesCompra(condicionesCompra);
			prov.setEstado(estado);
			ProveedorDAO.getInstancia().modificarProveedor(cuil, razonSocial, descuento, direccion, condicionesPago, condicionesCompra, estado);
		}
	}

	public Proveedor buscarProveedor(String cuil) throws RemoteException{
		for(Proveedor p:proveedores)
			if(p.getCuil().equals(cuil))
				return p;		
		return Proveedor.buscarProveedorDAO(cuil);
	}

	@Override
	public void cargarProveedores(String archivo) throws RemoteException{
		ListaProveedoresXmlDao.getInstancia().guardarEnBD(archivo);
	}

	// Punto 2
	// MR0506 - Cambio el metodo para que sea responsabilidad del Proveedor.
/*	@Override
	public void cargarListaDePrecios(String archivo) throws RemoteException{
		ListaDePreciosProvXmlDao.getInstancia().guardarEnBD(archivo);
	}
*/
	@Override
	public void cargarListaDePrecios(String archivo) throws RemoteException{
		Proveedor prov = null;
		Document doc = crearDocumento(archivo);
		prov = corroborarProveedorCorrecto(doc);
		if(prov!=null){
			prov.recuperarLP(doc);
		}
	}
	
	private Document crearDocumento(String archivo)	{
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try	{
			builder = factory.newDocumentBuilder();
			doc = builder.parse(archivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	private Proveedor corroborarProveedorCorrecto(Document doc) {
		Proveedor prov = null;
		Element ele = doc.getElementById("Proveedor"); 
		try {
			prov = buscarProveedor(ele.getAttribute("cuil"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return prov;
	}
	
	@Override
	public void crearListaComparativa() throws RemoteException {
		ListaComparativaDAO.getInstancia().crearLista();
	}

}
