package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import dao.ProveedorDAO;
import entities.ProveedorENT;

public class Proveedor {

	private String cuit;
	private String razonSocial;
	private String direccion;
	private List<CondCompraProv> condicionesCompra;
	private int LPVigente;
	private List<ListaPrecios> listasDePrecios;
	private String estado;
	
	public Proveedor(String cuit,String razonSocial, String direccion) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.condicionesCompra = new ArrayList<CondCompraProv>();
		LPVigente = 0;
		this.listasDePrecios = new ArrayList<ListaPrecios>();
		this.estado = "activo";
		ProveedorENT provENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(provENT);
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public List<CondCompraProv> getCondicionesCompra() {
		return condicionesCompra;
	}
	
	public void setCondicionesCompra(List<CondCompraProv> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
	
	public int getLPVigente() {
		return LPVigente;
	}
	
	public void setLPVigente(int lPVigente) {
		LPVigente = lPVigente;
	}
	
	public List<ListaPrecios> getListasDePrecios() {
		return listasDePrecios;
	}
	
	public void setListasDePrecios(List<ListaPrecios> listasDePrecios) {
		this.listasDePrecios = listasDePrecios;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public ProveedorENT toENT() {
		return new ProveedorENT(cuit, razonSocial, direccion, LPVigente, estado);
	}
/*
	public dto.Proveedor toDTO() {
		return new dto.Proveedor(this.condicionesCompra,this.cuit,this.direccion,this.estado,
						this.listasDePrecios,this.LPVigente,this.razonSocial);
	}
*/

	public static Proveedor buscarProveedorDAO(String cuit) {
		ProveedorENT provENT = ProveedorDAO.getInstancia().BuscarProveedor(cuit);
		return toDOM(provENT);
	}

	private static Proveedor toDOM(ProveedorENT provENT) {
		return new Proveedor(provENT.getCuil(), provENT.getRazonSocial(), provENT.getDireccion());
	}

	public void baja() {
		this.estado = "inactivo";
		ProveedorENT provENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(provENT);
	}

	public void modificar(String razonSocial, String direccion) {
		if(!direccion.isEmpty())
			this.direccion = direccion;
		if(!razonSocial.isEmpty())
			this.razonSocial = razonSocial;
		ProveedorENT provENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(provENT);
	}
	
}
