package dominio;

import entities.ItemSolENT;
import entities.SolicitudCotizacionENT;

public class ItemSolicitud {
	private int cantidad;
	private Rodamiento rodamiento;
	
	public ItemSolicitud() {
	}
	public ItemSolicitud(Rodamiento r, int cantidad) {
		// TODO Auto-generated constructor stub
		super();
		this.cantidad = cantidad;
		this.rodamiento = r;
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
	
	public ItemSolENT toENT (SolicitudCotizacionENT solicitudCotizacionENT) {
		return (new ItemSolENT(solicitudCotizacionENT, this.rodamiento.toENT(),this.cantidad));
	}
	
	public static ItemSolicitud toDOM(ItemSolENT iSolENT) {
		ItemSolicitud iSol = new ItemSolicitud(Rodamiento.toDOM(iSolENT.getId().getRodamiento()) ,iSolENT.getCantidad());
		return iSol;
	}
	
}