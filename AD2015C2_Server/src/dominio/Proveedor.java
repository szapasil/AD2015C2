package dominio;

import java.util.List;

public class Proveedor {
	private String razonSocial;
	private String direccion;
	private String cuil;
	private List<CondCompraProv> condicionesCompra;
	private int LPVigente;
	private List<ListaPrecios> listasDePrecios;
	private String estado;
	
	public Proveedor(String razonSocial, String direccion, String cuil,
			List<CondCompraProv> condicionesCompra, int lPVigente,
			List<ListaPrecios> listasDePrecios, String estado) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuil = cuil;
		this.condicionesCompra = condicionesCompra;
		LPVigente = lPVigente;
		this.listasDePrecios = listasDePrecios;
		this.estado = estado;
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
		return cuil;
	}
	
	public void setCuil(String cuil) {
		this.cuil = cuil;
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
		return new dto.Proveedor(this.condicionesCompra,this.cuil,this.direccion,this.estado,
						this.listasDePrecios,this.LPVigente,this.razonSocial);
	}
*/
}
