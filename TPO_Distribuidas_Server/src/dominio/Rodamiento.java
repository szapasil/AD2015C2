package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rodamientos")
public class Rodamiento {
	
	@Id
	private String codRodamiento;
	private String caracteristicas; 
	private String marca;
	private String origen;
	private String codSFK;
	
	public Rodamiento(String codRodamiento,String caracteristicas,String marca,String origen,String codSFK) {
		super();
		this.codRodamiento = codRodamiento;
		this.caracteristicas = caracteristicas;
		this.marca = marca;
		this.origen = origen;
		this.codSFK = codSFK;
	}

	public String getCodRodamiento() {
		return codRodamiento;
	}

	public void setCodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getCodSFK() {
		return codSFK;
	}

	public void setCodSFK(String codSFK) {
		this.codSFK = codSFK;
	}
	
	
}
