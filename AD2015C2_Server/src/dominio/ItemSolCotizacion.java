package dominio;

import entities.ItemSolCotizacionENT;
import entities.SolicitudCotizacionENT;

public class ItemSolCotizacion {
	private int cantidad;
	private Rodamiento rodamiento;
	
	public ItemSolCotizacion() {
	}

	public ItemSolCotizacion(Rodamiento r, int cantidad) {
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
	
	public ItemSolCotizacionENT toENT (SolicitudCotizacionENT solicitudCotizacionENT) {
		return (new ItemSolCotizacionENT(solicitudCotizacionENT, this.rodamiento.toENT(),this.cantidad));
	}
	
	public static ItemSolCotizacion toDOM(ItemSolCotizacionENT iSolENT) {
		ItemSolCotizacion iSol = new ItemSolCotizacion(Rodamiento.toDOM(iSolENT.getId().getRodamiento()) ,iSolENT.getCantidad());
		return iSol;
	}
	
}