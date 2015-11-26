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

import dao.ItemLCDAO;
import dao.ListaComparativaDAO;
import dao.SolicitudDeCompraDAO;
import dominio.ItemLC;
import dominio.ItemLP;
import dominio.ItemOC;
import dominio.ItemSolCompra;
import dominio.ListaPrecios;
import dominio.OrdenDeCompra;
import dominio.Proveedor;
import dominio.Rodamiento;
import dominio.SolicitudDeCompra;
import dominio.ListaComparativa;
import entities.ItemLCENT;
import entities.SolicitudDeCompraENT;

public class CC extends UnicastRemoteObject implements interfaz.ICC {	

	private static final long serialVersionUID = 1L;
	
	private List<OV> ovs;
	private List<Rodamiento> rodamientos;
	private List<Proveedor> proveedores;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private ListaComparativa listaComp;
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
		this.listaComp = null;
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
	
	public ListaComparativa getListaComp() {
		return listaComp;
	}

	public void setListaComp(ListaComparativa listaComp) {
		this.listaComp = listaComp;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
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

		public Rodamiento buscarRodamiento(String codRodamiento) {
			for(Rodamiento r:rodamientos)
				if(r.getCodRodamiento().equals(codRodamiento))
					return r;		
			return Rodamiento.buscarRodamientoDAO(codRodamiento);
		}
		
		public Rodamiento altaRodamientoXML(Element ele) {
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
		
		//PUNTO 2 - MANEJO DE LISTA DE PRECIOS
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
				listaComp = ListaComparativa.obtenerLC();
				if(listaComp == null){
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
					String codRodamiento = eleItem.getElementsByTagName("Codigo").item(0).getTextContent();
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

		//PUNTO 3 - MANEJO DE LISTA COMPARATIVA
		//ABM LISTA COMPARATIVA
		public void altaListaComp() throws RemoteException {
			ListaComparativa lc = new ListaComparativa();
				setListaComp(lc);
			}
		
		private void modificarListaComp(ListaPrecios lp) {
			boolean existe = false;
			ItemLC item = null;
			for(ItemLP ilp: lp.getItems()){
				for(ItemLC ilc:listaComp.getItemsLC()){
					System.out.println("itemLP: " + ilp.getRodamiento().getCodRodamiento()); //sacar
					System.out.println("itemLC: " + ilc.getRodamiento().getCodRodamiento()); //sacar 
					if(ilc.getRodamiento().getCodRodamiento().equals(ilp.getRodamiento().getCodRodamiento())){
						existe = true;
						if(ilc.getPrecio() > ilp.getPrecio())
							ilc.modificarItemLC(lp,ilp);
					}
				}
				if(!existe){
//					item = new ItemLC(ilp.getRodamiento(), ilp.getPrecio(), ilp.getStock(), ilp.getCondicionesCompra(), lp.getProveedor());
					item = new ItemLC(ilp.getRodamiento(), ilp.getPrecio(), ilp.getStock(), ilp.getCondcompra(), ilp.getBonificacion(), lp.getProveedor());
					listaComp.getItemsLC().add(item);
					item.persistirse();
				}
			}
		}
		
		//PUBLICAR LISTA COMPARATIVA
		public ItemLC publicarLC(Rodamiento rod, int cantidad) {
			listaComp = ListaComparativa.obtenerLC();
			ItemLC ilc = buscarEnLC(rod.getCodRodamiento());
			if(ilc==null)
				ilc = buscarMejorCodSFK(rod.getCodSFK());
			return ilc;
		}

		public ItemLC buscarMejorCodSFK(String codSFK) {
			float precioMin = Float.MAX_VALUE; 
			ItemLC item = null;
			for(ItemLC ilc: listaComp.getItemsLC()){
				if(ilc.getRodamiento().getCodSFK().equals(codSFK) && ilc.getPrecio()<precioMin)
					item = ilc;
			}
			return item;
		}

		//PUNTO 4 - COMPRA DE RODAMIENTOS
		//GENERAR ORDEN DE COMPRA
		public void generarOC(SolicitudDeCompra SC) {
			ItemLC itemLC = null; 
			List<SolicitudDeCompra> scPendientes = obtenerSCPendientes();
			for(SolicitudDeCompra sc:scPendientes){
				List<ItemSolCompra> itemsOC = new ArrayList<ItemSolCompra>();
				int cantidad = sc.getItems().size();
				while(cantidad>0){
					String cuitAnt = null;
					for(ItemSolCompra itemSC:sc.getItems()){
						itemLC = buscarEnLC(itemSC.getRodamiento().getCodRodamiento());
						if(itemLC.getProveedor().getCuit().equals(cuitAnt) || cuitAnt==null){
							itemsOC.add(itemSC);
							cuitAnt = itemLC.getProveedor().getCuit();
							sc.getItems().remove(itemSC);
							cantidad = cantidad - 1;
						}
					}
					altaOC(sc,itemsOC,cuitAnt);
				}
			}
		}
				
		public void altaOC(SolicitudDeCompra sc, List<ItemSolCompra> itemsSC, String cuitProv) {
			ItemOC ioc = null;
			float montoTotal = 0;
			OrdenDeCompra oc = new OrdenDeCompra();
			oc.setFecha(fechaHOY);
			oc.setProveedor(buscarProveedor(cuitProv));
			oc.setSolicitudDeCompra(sc);
			for(ItemSolCompra isc:itemsSC){
				ioc = new ItemOC(isc.getRodamiento(), isc.getCantidad(), isc.getPrecio());
				montoTotal = montoTotal + isc.getPrecio();
			}
			oc.setMontoTotal(montoTotal);
			oc.persistirse();
			ordenesDeCompra.add(oc);
		}

		public List<SolicitudDeCompra> obtenerSCPendientes() {
			return SolicitudDeCompra.buscarSCPendentesDAO();
		}

		public ItemLC buscarEnLC(String codRodamiento) {
			ItemLC item = null;
			boolean existe = false;	
			for(ItemLC ilc: listaComp.getItemsLC()){
				if(ilc.getRodamiento().getCodRodamiento().equals(codRodamiento)) {
					existe = true;
					item = ilc;
				}
			}
			if(!existe)
				item = ItemLC.buscarItemLCDAO(codRodamiento);
			return item;
		}

	//SILVIO INICIO >>>
		public OV getInstanciaOV (String nombreSucursal) throws RemoteException{
			OV ovTemp = null;
			for (OV ov : ovs) {
				if (ov.getSucursal().compareTo(nombreSucursal)==0)
					ovTemp=ov;
			}
			return ovTemp;
		}
		
		public void altaOV (String nombreSucursal) throws RemoteException {
				OV ovTemp = new OV(nombreSucursal);
				ovs.add(ovTemp);
		}
		
	//SILVIO FIN <<<
}
