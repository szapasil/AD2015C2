package dominio;

public class Proveedor {
	private String razonSocial;
	private String direccion;
	private String cuil;
	private String condicionesPago;
	private float descuento;
	private ListaPrecios listaPrecios;
	private String estado;


	public Proveedor(String razonSocial,String direccion,String cuil,String condicionesPago,float descuento) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuil = cuil;
		this.condicionesPago = condicionesPago;
		this.descuento = descuento;
		this.listaPrecios = new ListaPrecios();
		this.estado = "activo";
	}
	
	public Proveedor() {
		
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

	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
/*	
	public dto.Proveedor toDTO() {
		return new dto.Proveedor(this.razonSocial,this.direccion,this.cuil,this.condicionesPago,
								this.descuento,this.condicionesCompra,this.listaPrecios,this.estado);
	}
*/
}
