package dominio.TO;

import java.io.Serializable;
import java.util.List;

public class ProveedorTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String razonSocial;
	private String direccion;
	private String cuil;
	private String condicionesPago;
	private float descuento;
	private String condicionesCompra;
	private List<ListaPreciosTO> listasPrecios;
	private String estado;
	
	public ProveedorTO(String razonSocial, String direccion, String cuil, String condicionesPago, float descuento, 
			String condicionesCompra, List<ListaPreciosTO> listasPrecios, String estado) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuil = cuil;
		this.condicionesPago = condicionesPago;
		this.descuento = descuento;
		this.condicionesCompra = condicionesCompra;
		this.listasPrecios = listasPrecios;
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

	public String getCondicionesPago() {
		return condicionesPago;
	}

	public void setCondicionesPago(String condicionesPago) {
		this.condicionesPago = condicionesPago;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getCondicionesCompra() {
		return condicionesCompra;
	}

	public void setCondicionesCompra(String condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}

	public List<ListaPreciosTO> getListasPrecios() {
		return listasPrecios;
	}

	public void setListasPrecios(List<ListaPreciosTO> listasPrecios) {
		this.listasPrecios = listasPrecios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ProveedorTO [razonSocial=" + razonSocial + ", direccion=" + direccion + ", cuil=" + cuil 
				+ ", condicionesPago=" 	+ condicionesPago + ", descuento=" + descuento + ", condicionesCompra=" 
				+ condicionesCompra	+ ", listasPrecios=" + listasPrecios + ", estado=" + estado	+ "]";
	}

}
