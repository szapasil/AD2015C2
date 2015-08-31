package dominio.TO;


//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;


public class ClienteTO {

	private String razonSocial;
	private String cuil;
	private Date fechaRegistrado;
	private float montoTotal;
	private String direccion;
	//private List<SolicitudCotizacion> solicitudesContizacion;
	
	public ClienteTO(String razsoc, String cuil, Date fecha, float monto, String direccion)
	{
		this.razonSocial = razsoc;
		this.cuil = cuil;
		this.fechaRegistrado = fecha;
		this.montoTotal = monto;
		this.direccion = direccion;
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
	
	//public List<SolicitudCotizacion> getSolicitudesContizacion() {
	//	return solicitudesContizacion;
	//}
	
	//public void setSolicitudesContizacion(
	//		List<SolicitudCotizacion> solicitudesContizacion) {
	//	this.solicitudesContizacion = solicitudesContizacion;
	//}
}
