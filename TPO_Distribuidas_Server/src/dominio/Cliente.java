package dominio;

import java.util.*;

import javax.persistence.*;

import dominio.DAO.ClienteDAO;
import dominio.TO.ClienteTO;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@Column(length=11)
	private String cuil;
	private String razonSocial;
	private Date fechaRegistrado;
	private float montoTotal;
	private String direccion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private List<SolicitudCotizacion> solicitudesCotizacion;
	
	
	public Cliente(String razonSocial, String cuil, Date fechaRegistrado, float montoTotal, String direccion,
			       List<SolicitudCotizacion> solicitudesContizacion) {
		super();
		this.razonSocial = razonSocial;
		this.cuil = cuil;
		this.fechaRegistrado = fechaRegistrado;
		this.montoTotal = montoTotal;
		this.direccion = direccion;
		this.solicitudesCotizacion =  new ArrayList<SolicitudCotizacion>();
	}
	
	public Cliente()
	{
		
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getCuil() {
		return cuil;
	}
	
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	
	public Date getFechaRegistrado() {
		return fechaRegistrado;
	}
	
	public void setFechaRegistrado(Date fechaRegistrado) {
		this.fechaRegistrado = fechaRegistrado;
	}
	
	public float getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public List<SolicitudCotizacion> getSolicitudesContizacion() {
		return solicitudesCotizacion;
	}
	
	public void setSolicitudesContizacion(List<SolicitudCotizacion> solicitudesContizacion) {
		this.solicitudesCotizacion = solicitudesContizacion;
	}
	
	public ClienteTO getClienteTO(){
		return new ClienteTO(razonSocial, cuil, fechaRegistrado, montoTotal, direccion);
	}

	public static Cliente buscarClienteDAO(String cuil) {
		return ClienteDAO.getInstancia().BuscarCliente(cuil);
	}

}