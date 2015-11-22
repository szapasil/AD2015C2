package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dominio.ItemLC;
import dominio.ItemLP;
import dominio.ListaPrecios;
import dominio.OrdenDeCompra;
import dominio.Proveedor;
import dominio.Rodamiento;
import dominio.SolicitudDeCompra;
import dominio.ListaComp;

public class CC extends UnicastRemoteObject implements interfaz.ICC {	

	private static final long serialVersionUID = 1L;
	
	private List<OV> ovs;
	private List<Rodamiento> rodamientos;
	private List<Proveedor> proveedores;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private ListaComp ListaComp;
	private float porcentajeGanancia;
	
	private static CC instancia;
	
	public static CC getInstancia() throws RemoteException	{
		if (instancia== null)
			instancia = new CC();
		return instancia;
	}
	
	public CC() throws RemoteException {
		super();
		this.ovs = new ArrayList<OV>();
		this.rodamientos = new ArrayList<Rodamiento>();
		this.proveedores = new ArrayList<Proveedor>();
		this.ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		this.solicitudesDeCompra = new ArrayList<SolicitudDeCompra>();
		this.ListaComp = null;
		this.porcentajeGanancia = 35;
	}

	public List<OV> getOvs() {
		return ovs;
	}

	public void setOvs(List<OV> ovs) {
		this.ovs = ovs;
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
	
	public ListaComp getListaComp() {
		return ListaComp;
	}

	public void setListaComp(ListaComp listaComp) {
		ListaComp = listaComp;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	//PUNTO 1 - ABM PROVEEDOR
	public void altaProveedor(String cuit, String razonSocial, String direccion) throws RemoteException {
		Proveedor prov = buscarProveedor(cuit);
		if(prov==null) {
			prov = new Proveedor(cuit, razonSocial, direccion);
			proveedores.add(prov);
		}
		else
			System.out.print("Ya existe un Proveedor con ese cuit");
	}
	
	public Proveedor buscarProveedor(String cuit) throws RemoteException{
		for(Proveedor p:proveedores)
			if(p.getCuit().equals(cuit))
				return p;		
		return Proveedor.buscarProveedorDAO(cuit);
	}

	public void bajaProveedor(String cuit) throws RemoteException {
		Proveedor prov = buscarProveedor(cuit);
		if(prov!=null) {
			prov.baja();
		}
		else
			System.out.print("No existe un Proveedor con ese cuit");
	}

	public void modificarProveedor(String cuit,String razonSocial, String direccion) throws RemoteException {
		Proveedor prov = buscarProveedor(cuit);
		if(prov!=null) {
			prov.modificar(razonSocial,direccion,0);
		}
		else
			System.out.print("No existe un Proveedor con ese cuit");
	}
	
	//ABM RODAMIENTO
		public void altaRodamiento(String codRodamiento, String marca, String pais,	String tipo,
				String medidas, String codSFK) throws RemoteException {
			Rodamiento rod = buscarRodamiento(codRodamiento);
			if(rod==null) {
				rod = new Rodamiento(codRodamiento, marca, pais, tipo, medidas, codSFK);
				rodamientos.add(rod);
			}
			else
				System.out.print("Ya existe un Rodamiento con ese codigo");
		}

		private Rodamiento buscarRodamiento(String codRodamiento) {
			for(Rodamiento r:rodamientos)
				if(r.getCodRodamiento().equals(codRodamiento))
					return r;		
			return Rodamiento.buscarRodamientoDAO(codRodamiento);
		}
		
		private Rodamiento altaRodamientoXML(Element ele) {
			Rodamiento rod = new Rodamiento();
			rod.setCodRodamiento(ele.getElementsByTagName("Codigo").item(0).getTextContent());
			rod.setCodSFK(ele.getElementsByTagName("CodSFK").item(0).getTextContent());
			rod.setMarca(ele.getElementsByTagName("Marca").item(0).getTextContent());
			rod.setMedidas(ele.getElementsByTagName("Medidas").item(0).getTextContent());
			rod.setPais(ele.getElementsByTagName("Pais").item(0).getTextContent());
			rod.setTipo(ele.getElementsByTagName("Tipo").item(0).getTextContent());
			rod.persistirse();
			rodamientos.add(rod);
			return rod;
		}
		
		public void bajaRodamiento(String codRodamiento) throws RemoteException {
			Rodamiento rod = buscarRodamiento(codRodamiento);
			if(rod!=null) {
				rod.baja();
				rodamientos.remove(rod);
			}
			else
				System.out.print("No existe un Rodamiento con ese codigo");
		}

		public void modificarRodamiento(String codRodamiento,String marca, String pais,	String tipo,
				String medidas, String codSFK) throws RemoteException {
			Rodamiento rod = buscarRodamiento(codRodamiento);
			if(rod!=null) {
				rod.modificar(marca, pais, tipo, medidas, codSFK);
			}
			else
				System.out.print("No existe un Rodamiento con ese codigo");
		}
		
		//ALTA LISTA DE PRECIOS
		public void altaListaPrecios(String archivo) throws RemoteException, ParseException {
			ListaPrecios lp = null;
			Document doc = crearDocumento(archivo);
			NodeList nList = doc.getElementsByTagName("ListaPrecios");
			for (int i=0;i < nList.getLength(); i++){
				if (nList.item(i).hasChildNodes()){
					Element ele = (Element)nList.item(i);
					lp = armarCabeceraLP(ele);
					if(lp!=null)
						armarDetalleLP(ele,lp);
				}
			}
			if(lp!=null){
				if(ListaComp == null){
					altaListaComp();
					modificarListaComp(lp);
				}
				else
					modificarListaComp(lp);
			}
		}

		private ListaPrecios armarCabeceraLP(Element ele) throws DOMException, ParseException, RemoteException {
			ListaPrecios lp = null;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsed = format.parse(ele.getElementsByTagName("Fecha").item(0).getTextContent());
			Date fechaLP = new java.sql.Date(parsed.getTime());
			int nroLP = Integer.parseInt(ele.getElementsByTagName("Numero").item(0).getTextContent());
			Proveedor prov = buscarProveedor(ele.getElementsByTagName("Proveedor").item(0).getTextContent());
			if(prov!=null)
				lp = prov.obtenerLP(fechaLP,nroLP);
			return lp;
		}
		
		private void armarDetalleLP(Element ele, ListaPrecios lp) {
			Document doc = ele.getOwnerDocument();
			NodeList nList = doc.getElementsByTagName("Item");
			for (int i=0;i < nList.getLength(); i++){
				if (nList.item(i).hasChildNodes()){
					Element eleItem = (Element)nList.item(i);
					String codRodamiento = ele.getElementsByTagName("Codigo").item(0).getTextContent();
					Rodamiento rod = buscarRodamiento(codRodamiento);
					if(rod==null)
						rod = altaRodamientoXML(eleItem);
					lp.agregarItem(eleItem,rod);
				}
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

		//ABM LISTA COMPARATIVA
		public void altaListaComp() throws RemoteException {
			ListaComp lc = new ListaComp();
				setListaComp(lc);
			}
		
		private void modificarListaComp(ListaPrecios lp) {
			boolean existe = false;
			ItemLC item = null;
			for(ItemLP ilp: lp.getItems()){
				for(ItemLC ilc: ListaComp.getItemsLC()){
					if(ilc.getRodamiento().getCodRodamiento().equals(ilp.getRodamiento().getCodRodamiento())){
						existe = true;
						if(ilc.getPrecio() > ilp.getPrecio())
							ilc.modificarItemLC(lp,ilp);
					}
				}
				if(!existe){
					item = new ItemLC(ilp.getRodamiento(), ilp.getPrecio(), ilp.getStock(), ilp.getCondicionesCompra(), lp.getProveedor());
					ListaComp.getItemsLC().add(item);
					item.persistirse();
				}
			}
		}
		
		//GENERAR ORDEN DE COMPRA
		public String generarOC(SolicitudDeCompra SC) {
			return null;
		}
}
