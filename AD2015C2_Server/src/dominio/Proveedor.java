package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import dao.ProveedorDAO;

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
		LPVigente = -1;
		this.listasDePrecios = new ArrayList<ListaPrecios>();
		this.estado = "activo";
		HibernateDAO.getInstancia().saveOrUpdate(this);
		//ProveedorDAO.getInstancia().Insert(this);
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
	
	public String getCuil() {
		return cuit;
	}
	
	public void setCuil(String cuit) {
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
/*
	public dto.Proveedor toDTO() {
		return new dto.Proveedor(this.condicionesCompra,this.cuit,this.direccion,this.estado,
						this.listasDePrecios,this.LPVigente,this.razonSocial);
	}
*/
}
