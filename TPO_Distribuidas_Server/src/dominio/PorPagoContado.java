package dominio;

public class PorPagoContado extends PoliticaDescuento{
	
	private float descuento;
	
	public PorPagoContado(boolean estado, float descuento) {
		super(estado);
		this.descuento = descuento;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float calcularPolitica(Venta v) {
		// TODO Auto-generated method stub
		return 0;
	}
}
