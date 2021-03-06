package entities;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsLC")
//public class ItemLCENT {
public class ItemLCENT extends PersistentObject{
	
//	@Id
	@OneToOne
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private float precio;
	private int stock;
	private int condCompra;
	private int bonificacion;
	
	@OneToOne
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;

//	@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@JoinColumn(name="itemLC")
//	private List<CondCompraENT> condicionesCompra;
	
	public ItemLCENT() {
		
	}

	public ItemLCENT(RodamientoENT rodamiento, float precio, int stock, int condCompra, 
			int bonificacion, ProveedorENT proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
//		this.condicionesCompra = new ArrayList<CondCompraENT>();
		this.proveedor = proveedor;
	}

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
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

//	public List<CondCompraENT> getCondicionesCompra() {
//		return condicionesCompra;
//	}

//	public void setCondicionesCompra(List<CondCompraENT> condicionesCompra) {
//		this.condicionesCompra = condicionesCompra;
//	}
	
	public int getCondCompra() {
		return condCompra;
	}

	public void setCondCompra(int condCompra) {
		this.condCompra = condCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public ProveedorENT getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}
	
}
