package dominio;

public class ItemSolicitud {
	
	int cantidad;
	String codRodamiento;
	
	
	public ItemSolicitud(int cantidad, String codRodamiento) {
		super();
		this.cantidad = cantidad;
		this.codRodamiento = codRodamiento;
	}	
	

	public ItemSolicitud() {
		
		
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getCodRodamiento() {
		return codRodamiento;
	}


	public void setCodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}
	
	
	
	
	
}



