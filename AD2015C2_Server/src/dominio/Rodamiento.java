package dominio;

public class Rodamiento {

	private String codRodamiento;
	private String marca;
	private String pais;
	private String tipo;
	private String medidas;
	private String codSFK;
	
	public Rodamiento(String codRodamiento, String marca, String pais, String tipo, 
			String medidas, String codSFK) {
		super();
		this.codRodamiento = codRodamiento;
		this.marca = marca;
		this.pais = pais;
		this.tipo = tipo;
		this.medidas = medidas;
		this.codSFK = codSFK;
	}
	
	public Rodamiento() {
	
	}

	public String getCodRodamiento() {
		return codRodamiento;
	}

	public void setCodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public String getCodSFK() {
		return codSFK;
	}

	public void setCodSFK(String codSFK) {
		this.codSFK = codSFK;
	}

/*
	public dto.Rodamiento toDTO() {
		return new dto.Rodamiento(this.codRodamiento,this.codSFK,this.marca,this.medidas,
								this.pais,this.stock,this.tipo);
	}
*/	
}
