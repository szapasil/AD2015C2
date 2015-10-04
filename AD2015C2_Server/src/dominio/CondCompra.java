package dominio;

public class CondCompra {

	private String tipo;
	private String valor;
	private float bonificacion;
	
	public CondCompra(String tipo, String valor, float bonificacion) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.bonificacion = bonificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public float getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(float bonificacion) {
		this.bonificacion = bonificacion;
	}
/*
	public dto.CondCompra toDTO() {
		return new dto.ConCompra(this.bonificacion,this.tipo,this.valor);
	}
*/		
}
