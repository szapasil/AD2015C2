package dominio;

public class CondPago {

	int cantDias;
	float recargo;
	
	
	public CondPago(int cantDias, float recargo) {
		super();
		this.cantDias = cantDias;
		this.recargo = recargo;
	}
	
	public CondPago(){
		
		
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public float getRecargo() {
		return recargo;
	}

	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}
	
	
	
	
}
