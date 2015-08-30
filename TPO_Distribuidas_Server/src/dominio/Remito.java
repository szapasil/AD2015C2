package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="remitos")
public class Remito {
	
	private int numero;
	private Date fechaEnvio;
	private String estado;
	private String situacion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item")
	private List<ItemRemito> items; 	
	
	public Remito(int numero, Date fechaEnvio, String estado, String situacion,
			List<ItemRemito> items) {
		super();
		this.numero = numero;
		this.fechaEnvio = fechaEnvio;
		this.estado = estado;
		this.situacion = situacion;
		this.items = new ArrayList<ItemRemito>();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getSituacion() {
		return situacion;
	}
	
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	
	public List<ItemRemito> getItems() {
		return items;
	}
	
	public void setItems(List<ItemRemito> items) {
		this.items = items;
	}

}
