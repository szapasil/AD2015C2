package dto;

import java.io.Serializable;

public class ItemLCDTO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RodamientoDTO rodamiento;
	private float precio;
	private int stock;
	private int condCompra;
	private int bonificacion;
	private String cuitProveedor;
//	private List<CondCompra> condicionesCompra;
//	private ProveedorDTO proveedor;
	
	public ItemLCDTO() {
		
	}

//	public ItemLC(Rodamiento rodamiento, float precio, int stock, int condCompra, 
//			int bonificacion, Proveedor proveedor) {
	public ItemLCDTO(RodamientoDTO rodamientoDTO, float precio, int stock, int condCompra, int bonificacion, String cuitProveedor) {
		super();
		this.rodamiento = rodamientoDTO;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
		this.cuitProveedor = cuitProveedor;
//		this.proveedor = proveedor;
	}

	public RodamientoDTO getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoDTO rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCondcompra() {
		return condCompra;
	}

	public void setCondcompra(int condCompra) {
		this.condCompra = condCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	
	public String getCuitProveedor() {
		return cuitProveedor;
	}

	public void setCuitProveedor(String cuitProveedor) {
		this.cuitProveedor = cuitProveedor;
	}

//	public Proveedor getProveedor() {
//		return proveedor;
//	}

//	public void setProveedor(Proveedor proveedor) {
//		this.proveedor = proveedor;
//	}

}
