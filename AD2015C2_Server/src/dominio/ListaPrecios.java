package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ListaPrecios {

	private int numero;
	private Date fecha;
	private Proveedor proveedor;
	private List<ItemLP> items;

	public ListaPrecios(int numero, Date fecha, Proveedor proveedor, List<ItemLP> items) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.items = new ArrayList<ItemLP>();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public List<ItemLP> getItems() {
		return items;
	}
	
	public void setItems(List<ItemLP> items) {
		this.items = items;
	}
/*
	public dto.ListaPrecios toDTO() {
		return new dto.ListaPrecios(this.fecha,this.items,.this.numero,this.proveedor);
	}
*/	
}
