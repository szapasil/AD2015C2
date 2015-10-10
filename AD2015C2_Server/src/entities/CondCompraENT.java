package entities;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="condicionesCompra")
public class CondCompraENT extends PersistentObject {

	private String tipo;
	private String valor;
	private float bonificacion;
	
	public CondCompraENT(String tipo, String valor, float bonificacion) {
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
	
}
