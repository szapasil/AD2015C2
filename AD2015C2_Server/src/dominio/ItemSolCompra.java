package dominio;

import entities.ItemSolCompraENT;
import entities.SolicitudDeCompraENT;

public class ItemSolCompra {
	
	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	private Proveedor proveedor;
	
	public ItemSolCompra(Rodamiento rodamiento, int cantidad, float precio, Proveedor proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedor = proveedor;
//		persistirse();
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

//	public void persistirse() {
//		ItemSolCompraENT iscENT = toENT();
//		HibernateDAO.getInstancia().saveOrUpdate(iscENT);
//	}

	public ItemSolCompraENT toENT(SolicitudDeCompraENT scENT) {
		return new ItemSolCompraENT(rodamiento.toENT(), scENT, cantidad, precio, proveedor.toENT());
	}
}
