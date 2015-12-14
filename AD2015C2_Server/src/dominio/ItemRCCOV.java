package dominio;

import entities.ItemRCCOVENT;
import entities.RemitoCCOVENT;

public class ItemRCCOV {

	private Rodamiento rodamiento;
	private int cantidad;
	
	public ItemRCCOV(Rodamiento rodamiento, int cantidad) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
	}

	public ItemRCCOV() {
		
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

	public ItemRCCOVENT toENT(RemitoCCOVENT rccovENT) {
		return new ItemRCCOVENT(rccovENT, rodamiento.toENT(), cantidad);
	}
	
}
