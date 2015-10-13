package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dominio.OrdenDeCompra;
import dominio.Proveedor;
import dominio.Rodamiento;
import dominio.SolicitudDeCompra;

public class CC extends UnicastRemoteObject implements interfaz.ICC {	

	private static final long serialVersionUID = 1L;
	
	private List<OV> ovs;
	private List<Rodamiento> rodamientos;
	private List<Proveedor> proveedores;
	private List<OrdenDeCompra> ordenesDeCompra;
	private List<SolicitudDeCompra> solicitudesDeCompra;
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
			prov.modificar(razonSocial,direccion);
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
}
