package dominio;

import entities.ItemRPCCENT;
import entities.RemitoProvCCENT;

public class ItemRPCC {

	private Rodamiento rodamiento;
	private int cantidad;
	
	public ItemRPCC(Rodamiento rodamiento, int cantidad) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
	}

	public ItemRPCC() {

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

	public ItemRPCCENT toENT(RemitoProvCCENT rpccENT) {
		return new ItemRPCCENT(rpccENT, rodamiento.toENT(), cantidad);
	}
	
}
