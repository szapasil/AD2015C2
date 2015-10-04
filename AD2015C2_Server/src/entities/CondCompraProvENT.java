package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="condicionesCompraProv")
public class CondCompraProvENT {

	private String tipo;
	private int valor;
	private float bonificacion;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public float getBonificacion() {
		return bonificacion;
	}
	
	public void setBonificacion(float bonificacion) {
		this.bonificacion = bonificacion;
	}

}
