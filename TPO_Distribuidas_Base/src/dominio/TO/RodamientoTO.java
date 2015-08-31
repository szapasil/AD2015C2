package dominio.TO;

import java.io.Serializable;

public class RodamientoTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String tipo;
	private String medidas;
	private String importado;
	private String caracteristicas;
	private MarcaTO marca;
	private String origen;
	
	public RodamientoTO(String codigo, String tipo, String medidas,
			String importado, String caracteristicas, MarcaTO marca,
			String origen) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.medidas = medidas;
		this.importado = importado;
		this.caracteristicas = caracteristicas;
		this.marca = marca;
		this.origen = origen;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public MarcaTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaTO marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "RodamientoTO [codigo=" + codigo + ", tipo=" + tipo
				+ ", medidas=" + medidas + ", importado=" + importado
				+ ", caracteristicas=" + caracteristicas + ", marca=" + marca
				+ ", origen=" + origen + "]";
	}

}
