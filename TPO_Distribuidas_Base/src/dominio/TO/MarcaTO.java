package dominio.TO;

import java.io.Serializable;

public class MarcaTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String tipo;
	
	public MarcaTO(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "MarcaTO [nombre=" + nombre + ", tipo=" + tipo + "]";
	}

}
