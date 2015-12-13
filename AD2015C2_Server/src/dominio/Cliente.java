package dominio;

import hbt.HibernateDAO;

import java.rmi.RemoteException;
import java.sql.Date;
import app.CC;
import app.OV;
import dao.ClienteDAO;
import entities.ClienteENT;

public class Cliente {
	private OV ov;
	private String razonSocial;
	private String direccion;
	private String cuil;
	private String condicionIVA;
	//private List<CondPago> condicionesPago;
	private String condicionPago;
	private float descuento;
	private java.sql.Date fechaRegistro;
	//private List<SolicitudCotizacion> solicitudesCotizacion;



/*public Cliente(String cuil, String razonSocial, String direccion) {
	super();
	this.razonSocial = razonSocial;
	this.direccion = direccion;
	this.cuil = cuil;
	persistirse();
}*/


public Cliente(OV ov, String razonSocial, String direccion, String cuil,
		String condicionIVA, String condicionPago, float descuento) {
	super();
	this.ov = ov;
	this.razonSocial = razonSocial;
	this.direccion = direccion;
	this.cuil = cuil;
	this.condicionIVA = condicionIVA;
	this.condicionPago = condicionPago;
	this.descuento = descuento;
	Date fechaHoy = new java.sql.Date(System.currentTimeMillis());
	this.fechaRegistro = fechaHoy;
	persistirse();
}


private void persistirse() {
	ClienteENT clienteENT = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(clienteENT);
}


public OV getOv() {
	return ov;
}


public void setOv(OV ov) {
	this.ov = ov;
}


public String getCondicionPago() {
	return condicionPago;
}


public void setCondicionPago(String condicionPago) {
	this.condicionPago = condicionPago;
}


public float geteDescuento() {
	return descuento;
}


public void setDescuento(float descuento) {
	this.descuento = descuento;
}


public Cliente() {
	super();
}
public String getCondicionIVA() {
	return condicionIVA;
}
public void setCondicionIVA(String condicionIVA) {
	this.condicionIVA = condicionIVA;
}

public String getRazonSocial() {
	return razonSocial;
}

public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getCuil() {
	return cuil;
}

public void setCuil(String cuil) {
	this.cuil = cuil;
}


public Date getFechaRegistro() {
	return fechaRegistro;
}

public void setFechaRegistro(java.sql.Date fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
}
	
public static Cliente buscarClienteDAO(String cuil) throws RemoteException {
	
	ClienteENT cliENT =  ClienteDAO.getInstancia().BuscarCliente(cuil);
	if(cliENT!=null)
		return toDOM(cliENT);
	return null;
}
	
public void modificar(String razonSocial, String direccion) {
	if(!direccion.isEmpty())
		this.direccion = direccion;
	if(!razonSocial.isEmpty())
		this.razonSocial = razonSocial; 
	ClienteENT cliENT  = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(cliENT);
}


public static Cliente toDOM(ClienteENT cliENT) throws RemoteException {
		Cliente c = new Cliente();
		c.ov = CC.getInstancia().getInstanciaOV(cliENT.getOv().getNumeroSucursal());
		c.razonSocial = cliENT.getRazonSocial();
		c.direccion = cliENT.getDireccion();
		c.cuil = cliENT.getCuil();
		c.condicionIVA = cliENT.getCondicionIVA();
		c.condicionPago = cliENT.getCondicionesPago();
		c.descuento = cliENT.getPorcentajeDescuento();
		c.fechaRegistro = cliENT.getFechaRegistro();
		return c;
}

public ClienteENT toENT() {
	return new 	ClienteENT ( cuil, ov.toENT() ,  razonSocial,
			 direccion,  fechaRegistro,  descuento,
			 condicionPago, condicionIVA);
}


/* TODO: Ver esta operacion*/
public int calcularAntiguedad(){
	
	int ant = 0;
	
	
	return ant;
}

public void baja() {
	ClienteENT cliENT = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(cliENT);
	
}





}
