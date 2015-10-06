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
	@Override
	public void altaProveedor(String cuit, String razonSocial, String direccion) throws RemoteException {
//		Proveedor prov = buscarProveedor(cuit);
//		if(prov==null) {
			Proveedor prov = new Proveedor(cuit, razonSocial, direccion);
			proveedores.add(prov);
//		}
	}

}
