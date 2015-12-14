package dominio;

import java.rmi.RemoteException;

import dto.ItemLCDTO;
import app.CC;

public class ItemCotizacion {

	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	private int condicionCompra;
	private int bonificacion;
	private Proveedor proveedor;
	
	public ItemCotizacion () {
	}
	
	public ItemCotizacion (String codRodamiento, int cantidad, float precio, int condicionCompra,
				int bonificacion, Proveedor proveedor) throws RemoteException {
		super();
			this.rodamiento = CC.getInstancia().buscarRodamiento(codRodamiento);
			this.cantidad = cantidad;
			this.precio = precio;
			this.condicionCompra = condicionCompra;
			this.bonificacion = bonificacion;
			this.proveedor = proveedor;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getCondicionCompra() {
		return condicionCompra;
	}

	public void setCondicionCompra(int condicionCompra) {
		this.condicionCompra = condicionCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public void CotizarItem(ItemLCDTO ilcDTO, ItemSolCotizacion isc) throws RemoteException {
		setRodamiento(isc.getRodamiento());
		setCantidad(isc.getCantidad());
		setPrecio(ilcDTO.getPrecio());
		setCondicionCompra(ilcDTO.getCondcompra());
		setBonificacion(ilcDTO.getBonificacion());
		setProveedor(CC.getInstancia().buscarProveedor(ilcDTO.getCuitProveedor()));
	}
	
	
	
}
