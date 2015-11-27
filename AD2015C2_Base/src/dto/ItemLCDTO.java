package dto;

public class ItemLCDTO {
//	private RodamientoDTO rodamiento;
	private float precio;
	private int stock;
	private int condCompra;
	private int bonificacion;
//	private List<CondCompra> condicionesCompra;
//	private ProveedorDTO proveedor;
	
	public ItemLCDTO() {
		
	}

//	public ItemLC(Rodamiento rodamiento, float precio, int stock, int condCompra, 
//			int bonificacion, Proveedor proveedor) {
	public ItemLCDTO(float precio, int stock, int condCompra, int bonificacion) {
		super();
//		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
//		this.proveedor = proveedor;
	}

//	public Rodamiento getRodamiento() {
//		return rodamiento;
//	}

//	public void setRodamiento(Rodamiento rodamiento) {
//		this.rodamiento = rodamiento;
//	}

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

//	public Proveedor getProveedor() {
//		return proveedor;
//	}

//	public void setProveedor(Proveedor proveedor) {
//		this.proveedor = proveedor;
//	}

}
