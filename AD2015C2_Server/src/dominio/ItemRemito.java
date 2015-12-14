package dominio;

public class ItemRemito {
	
	private Rodamiento rodamiento;
	private int cantidad;
	
	public ItemRemito(Rodamiento rodamiento, int cantidad) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
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
	
}
