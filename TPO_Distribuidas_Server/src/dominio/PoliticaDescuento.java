package dominio;

public abstract class PoliticaDescuento { //Clase abstracta del Strategy
	
	private boolean estado;

	public PoliticaDescuento(boolean estado) {
		super();
		this.estado = estado;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public abstract float calcularPolitica(Venta v);
	
}
