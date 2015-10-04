package entities;

import java.util.List;

import javax.persistence.*;

public class ProveedorENT {

	@Id
	private String cuil;
	private String razonSocial;
	private String direccion;
	private List<CondCompraProvENT> condicionesCompra;
	private int LPVigente;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="listasDePrecios")
	private List<ListaPreciosENT> listasDePrecios;
	private String estado;
	
	public String getCuil() {
		return cuil;
	}
	
	public void setCuil(String cuil) {
		this.cuil = cuil;
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
		return condicionesCompra;
	}
	
	public void setCondicionesCompra(List<CondCompraProvENT> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
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
