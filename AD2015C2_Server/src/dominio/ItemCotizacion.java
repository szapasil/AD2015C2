package dominio;

import java.rmi.RemoteException;

import app.CC;

public class ItemCotizacion {

	private int cantidad;
	private Rodamiento rodamiento;
	private float precio;
	
	public ItemCotizacion () {
	}
	public ItemCotizacion (String codRodamiento, int cantidad, float precio) {
		super();
		try {
			this.rodamiento = CC.getInstancia().buscarRodamiento(codRodamiento);
			this.cantidad=cantidad;
			this.precio=precio;
			} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
	
}
