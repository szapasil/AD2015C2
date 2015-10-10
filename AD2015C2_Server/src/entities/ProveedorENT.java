package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dominio.CondCompraProv;
import dominio.ListaPrecios;

@Entity
@Table(name="proveedores")
public class ProveedorENT {

	@Id
	private String cuit;
	private String razonSocial;
	private String direccion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private List<CondCompraProvENT> condicionesCompraProv;
	private int LPVigente;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private List<ListaPreciosENT> listasDePrecios;
	private String estado;
	
	public ProveedorENT() {
		
	}
	
	public ProveedorENT(String cuit, String razonSocial, String direccion, int lPVigente, String estado) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.condicionesCompraProv = new ArrayList<CondCompraProvENT>();
		this.LPVigente = lPVigente;
		this.listasDePrecios = new ArrayList<ListaPreciosENT>();
		this.estado = estado;
	}

	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
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
	
	public List<CondCompraProvENT> getCondicionesCompra() {
		return condicionesCompraProv;
	}
	
	public void setCondicionesCompra(List<CondCompraProvENT> condicionesCompraProv) {
		this.condicionesCompraProv = condicionesCompraProv;
	}
	
	public int getLPVigente() {
		return LPVigente;
	}
	
	public void setLPVigente(int lPVigente) {
		LPVigente = lPVigente;
	}
	
	public List<ListaPreciosENT> getListasDePrecios() {
		return listasDePrecios;
	}
	
	public void setListasDePrecios(List<ListaPreciosENT> listasDePrecios) {
		this.listasDePrecios = listasDePrecios;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
