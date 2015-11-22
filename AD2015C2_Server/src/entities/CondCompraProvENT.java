package entities;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="condicionesCompraProv")
public class CondCompraProvENT extends PersistentObject{

	private String tipo;
	private int valor;
	private float bonificacion;
	
	public CondCompraProvENT() {
		
	}
	
	public CondCompraProvENT(String tipo, int valor, float bonificacion) {
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
