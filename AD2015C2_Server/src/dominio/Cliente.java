package dominio;

import hbt.HibernateDAO;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import app.CC;
import app.OV;
import dao.ClienteDAO;
import entities.ClienteENT;
import entities.OVENT;

public class Cliente {
	private OV ov;
	private String razonSocial;
	private String direccion;
	private String cuil;
	private String condicionIVA;
	//private List<CondPago> condicionesPago;
	private String condicionesPago;
	private float porcentajeDescuento;
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
		String condicionIVA, String condicionesPago, float porcentajeDescuento,
		Date fechaRegistro) {
	super();
	this.ov = ov;
	this.razonSocial = razonSocial;
	this.direccion = direccion;
	this.cuil = cuil;
	this.condicionIVA = condicionIVA;
	this.condicionesPago = condicionesPago;
	this.porcentajeDescuento = porcentajeDescuento;
	this.fechaRegistro = fechaRegistro;
	persistirse();
}


private void persistirse() {
	// TODO Auto-generated method stub
	ClienteENT clienteENT = toENT();
	HibernateDAO.getInstancia().saveOrUpdate(clienteENT);
}


public OV getOv() {
	return ov;
}


public void setOv(OV ov) {
	this.ov = ov;
}


public String getCondicionesPago() {
	return condicionesPago;
}


public void setCondicionesPago(String condicionesPago) {
	this.condicionesPago = condicionesPago;
}


public float getPorcentajeDescuento() {
	return porcentajeDescuento;
}


public void setPorcentajeDescuento(float porcentajeDescuento) {
	this.porcentajeDescuento = porcentajeDescuento;
}


public Cliente() {
	super();
	// TODO Auto-generated constructor stub
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
		c.condicionesPago = cliENT.getCondicionesPago();
		c.porcentajeDescuento = cliENT.getPorcentajeDescuento();
		c.fechaRegistro = cliENT.getFechaRegistro();
		return c;
}

public ClienteENT toENT() {
	return new 	ClienteENT ( cuil, ov.toENT() ,  razonSocial,
			 direccion,  fechaRegistro,  porcentajeDescuento,
			 condicionesPago, condicionIVA);
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
