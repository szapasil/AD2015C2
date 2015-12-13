package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Element;

import dominio.ItemLC;
import dominio.ItemLP;
import dominio.ItemSolCompra;
import dominio.ListaPrecios;
import dominio.OrdenDeCompra;
import dominio.Proveedor;
import dominio.RemitoCCOV;
import dominio.RemitoProvCC;
import dominio.RemitoTransporte;
import dominio.Rodamiento;
import dominio.SolicitudDeCompra;
import dto.ItemLCDTO;

public class CC extends UnicastRemoteObject implements interfaz.ICC {	

	private static final long serialVersionUID = 1L;
	
	private List<OV> ovs;
	private List<Rodamiento> rodamientos;
	private List<Proveedor> proveedores;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private List<ItemLC> listaComp;
	private List<RemitoProvCC> remitosProvCC;
	private List<RemitoCCOV> remitosCCOV;
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
		this.remitosCCOV = new ArrayList<RemitoCCOV>();
		this.remitosProvCC = new ArrayList<RemitoProvCC>();
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

	public List<ItemLC> getListaComp() {
		return listaComp;
	}

	public void setListaComp(List<ItemLC> listaComp) {
		this.listaComp = listaComp;
	}

	public List<RemitoProvCC> getRemitosProvCC() {
		return remitosProvCC;
	}

	public void setRemitosProvCC(List<RemitoProvCC> remitosProvCC) {
		this.remitosProvCC = remitosProvCC;
	}

	public List<RemitoCCOV> getRemitosCCOV() {
		return remitosCCOV;
	}

	public void setRemitosCCOV(List<RemitoCCOV> remitosCCOV) {
		this.remitosCCOV = remitosCCOV;
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
		ListaPrecios lp = ListaPrecios.fromXML(archivo);
		lp.persistirse();
		modificarListaComp(lp);
	}
	
	//PUNTO 3 - MANEJO DE LISTA COMPARATIVA
	//MODIFICAR LISTA COMPARATIVA	
	private void modificarListaComp(ListaPrecios lp) {
		listaComp = ItemLC.obtenerItemsLC();
		boolean existe = false;
		ItemLC item = null;
		for(ItemLP ilp: lp.getItems()){
			for(ItemLC ilc:listaComp){
				if(ilc.getRodamiento().getCodRodamiento().equals(ilp.getRodamiento().getCodRodamiento())){
					existe = true;
					if(ilc.getPrecio() > ilp.getPrecio())
						ilc.modificarItemLC(lp,ilp);
				}
			}
			if(!existe){
				item = new ItemLC(ilp.getRodamiento(), ilp.getPrecio(), ilp.getStock(), ilp.getCondcompra(), ilp.getBonificacion(), lp.getProveedor());
				listaComp.add(item);
				item.persistirse();
			}
		}	
	}

	//PUBLICAR LISTA COMPARATIVA
//		public ItemLCDTO publicarLC(String codRodamiento, String codSFK) {
	public ItemLCDTO publicarLC(String codRodamiento) {
		listaComp = ItemLC.obtenerItemsLC();
		ItemLC ilc = buscarEnLC(codRodamiento);
//			if(ilc==null)
//				ilc = buscarMejorCodSFK(codSFK);
		return ilc.toDTO();
	}

//		public ItemLC buscarMejorCodSFK(String codSFK) {
//			float precioMin = Float.MAX_VALUE; 
//			ItemLC item = null;
//			for(ItemLC ilc: listaComp){
//				if(ilc.getRodamiento().getCodSFK().equals(codSFK) && ilc.getPrecio()<precioMin)
//					item = ilc;
//			}
//			return item;
//		}

	//PUNTO 4 - COMPRA DE RODAMIENTOS
	//GENERAR ORDEN DE COMPRA
	public void generarOC() throws RemoteException {
		List<SolicitudDeCompra> scPendientes = obtenerSCPendientes();
		for(SolicitudDeCompra sc:scPendientes){
			int cantidad = sc.getItems().size();
			while(cantidad>0){
				List<ItemSolCompra> itemsOC = new ArrayList<ItemSolCompra>();
				String cuitAnt = null;
				for(ItemSolCompra itemSC:sc.getItems()){
					if(itemSC.getProveedor().getCuit().equals(cuitAnt) || cuitAnt==null){
						itemsOC.add(itemSC);
						cuitAnt = itemSC.getProveedor().getCuit();
						sc.getItems().remove(itemSC);
						cantidad = cantidad - 1;
					}
				}
				altaOC(sc,itemsOC,cuitAnt);
			}
			sc.setEstado("Enviada");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sc.getFechaEmision());
			calendar.add(Calendar.DAY_OF_YEAR, 30);
			sc.setFechaEntregaEstimada((Date)calendar.getTime());
			sc.persistirse();
		}
	}
			
	public void altaOC(SolicitudDeCompra sc, List<ItemSolCompra> itemsSC, String cuitProv) throws RemoteException {
		Proveedor prov = buscarProveedor(cuitProv);
		Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
		OrdenDeCompra oc = new OrdenDeCompra(prov, fechaHoy, sc);
		oc.agregarItems(itemsSC);
		oc.persistirse();
		ordenesDeCompra.add(oc);
		oc.toXML();
	}

	public List<SolicitudDeCompra> obtenerSCPendientes() {
		return SolicitudDeCompra.buscarSCPendentesDAO();
	}

	public ItemLC buscarEnLC(String codRodamiento) {
		ItemLC item = null;
		boolean existe = false;	
		for(ItemLC ilc: listaComp){
			if(ilc.getRodamiento().getCodRodamiento().equals(codRodamiento)) {
				existe = true;
				item = ilc;
			}
		}
		if(!existe)
			item = ItemLC.buscarItemLCDAO(codRodamiento);
		return item;
	}
	
	//PUNTO 5 - RECEPCION DE RODAMIENTOS
	//GENERAR ORDEN DE COMPRA
	public void recepcionRodamientos(String archivo) throws RemoteException {
		RemitoProvCC rpcc = RemitoProvCC.fromXML(archivo);
		rpcc.persistirse();
		remitosProvCC.add(rpcc);
		generarRemitosCCOV(rpcc);
	}
	
	public void generarRemitosCCOV(RemitoProvCC rpcc) throws RemoteException {
		RemitoTransporte rt = new RemitoTransporte();
		int cantidad = rpcc.getOrdenesDeCompra().size();
		while(cantidad>0){
			List<OrdenDeCompra> ocs = new ArrayList<OrdenDeCompra>();
			int ovAnt = 0;
			for(OrdenDeCompra oc:rpcc.getOrdenesDeCompra()){
				if(oc.getSolicitudDeCompra().getOv().getNumeroSucursal()==ovAnt || ovAnt==0){
					ocs.add(oc);
					ovAnt = oc.getSolicitudDeCompra().getOv().getNumeroSucursal();
					rpcc.getOrdenesDeCompra().remove(oc);
					cantidad = cantidad - 1;
				}
			}
			altaRCCOV(rpcc,ocs,ovAnt);
			rt.agregarPedidoOV(rpcc,ovAnt);
		}
		rt.toXML();
	}
		
	public void altaRCCOV(RemitoProvCC rpcc, List<OrdenDeCompra> ocs, int ovAnt) throws RemoteException {
		RemitoCCOV rccov = new RemitoCCOV();
		List<SolicitudDeCompra> scs = new ArrayList<SolicitudDeCompra>();
		for(OrdenDeCompra oc:ocs)
			scs.add(oc.getSolicitudDeCompra());
		rccov.setSolicitudesDeCompra(scs);
		rccov.setOV(buscarOV(ovAnt));
		Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
		rccov.setFecha(fechaHoy);
		rccov.agregarItems(rpcc);
		rccov.persistirse();
		remitosCCOV.add(rccov);
		rccov.toXML();
	}

	public OV buscarOV(int nroSucursal) throws RemoteException {
		for(OV ov:ovs)
			if(ov.getNumeroSucursal() == nroSucursal)
				return ov;		
		return OV.buscarOVDAO(nroSucursal);
	}
	
	public OrdenDeCompra buscarOC(int numero) {
		for(OrdenDeCompra oc:ordenesDeCompra)
			if(oc.getNumero() == numero)
				return oc;		
		return OrdenDeCompra.buscarOCDAO(numero);
	}

	//SILVIO INICIO >>>
	public OV getInstanciaOV (int numeroSucursal) throws RemoteException{
		OV ovTemp = null;
		for (OV ov : ovs) {
			if (ov.getNumeroSucursal() == numeroSucursal)
				ovTemp=ov;
		}
		return ovTemp;
	}
	
	public void altaOV (int numeroSucursal, String nombreSucursal) throws RemoteException {
			OV ovTemp = new OV(numeroSucursal, nombreSucursal);
			ovs.add(ovTemp);
	}
		
	//SILVIO FIN <<<
}
