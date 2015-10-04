package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rodamientos")
public class RodamientoENT {

	@Id
	private String codRodamiento;
	private String marca;
	private String pais;
	private String tipo;
	private String medidas;
	private String codSFK;
	private int stock;
	
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
