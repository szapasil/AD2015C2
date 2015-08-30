package dominio;

import javax.persistence.Embeddable;

import dominio.TO.MarcaTO;

@Embeddable
public class Marca {
	
	private String nombre;
	private String tipo;
	
	public Marca(String nombre, String tipo) {
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
	
	public MarcaTO getMarcaTO() {
		return new MarcaTO(nombre,tipo);
	}
	
}
