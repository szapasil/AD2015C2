package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dao.ProveedorDAO;
import entities.ProveedorENT;

public class Proveedor {

	private String cuit;
	private String razonSocial;
	private String direccion;
	private List<CondCompraProv> condicionesCompra;
	private int LPVigente;
	private List<ListaPrecios> listasDePrecios;
	private String estado;
	
	public Proveedor(String cuit,String razonSocial, String direccion) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.condicionesCompra = new ArrayList<CondCompraProv>();
		this.LPVigente = 0;
		this.listasDePrecios = new ArrayList<ListaPrecios>();
		this.estado = "activo";
		persistirse();
	}

	public Proveedor() {
		
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
	
	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public List<CondCompraProv> getCondicionesCompra() {
		return condicionesCompra;
	}
	
	public void setCondicionesCompra(List<CondCompraProv> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
	
	public int getLPVigente() {
		return LPVigente;
	}
	
	public void setLPVigente(int lPVigente) {
		LPVigente = lPVigente;
	}
	
	public List<ListaPrecios> getListasDePrecios() {
		return listasDePrecios;
	}
	
	public void setListasDePrecios(List<ListaPrecios> listasDePrecios) {
		this.listasDePrecios = listasDePrecios;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static Proveedor buscarProveedorDAO(String cuit) {
		ProveedorENT provENT = ProveedorDAO.getInstancia().BuscarProveedor(cuit);
		if(provENT!=null)
			return toDOM(provENT);
		return null;
	}

	public void baja() {
		this.estado = "inactivo";
		ProveedorENT provENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(provENT);
	}

	public void modificar(String razonSocial, String direccion, int lpVigente) {
		if(!direccion.isEmpty())
			this.direccion = direccion;
		if(!razonSocial.isEmpty())
			this.razonSocial = razonSocial;
		if(lpVigente != 0)
			this.LPVigente = lpVigente;
		persistirse();
	}
	
	public void persistirse() {
		ProveedorENT provENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(provENT);
	}
	
	public ProveedorENT toENT() {
		return new ProveedorENT(cuit, razonSocial, direccion, LPVigente, estado);
	}
	
	public static Proveedor toDOM(ProveedorENT provENT) {
		Proveedor prov = new Proveedor();
//		prov.setCondicionesCompra(condicionesCompra);
		prov.setCuit(provENT.getCuit());
		prov.setDireccion(provENT.getDireccion());
		prov.setEstado(provENT.getEstado());
		prov.setLPVigente(provENT.getLPVigente());
		prov.setRazonSocial(provENT.getRazonSocial());
		return prov;
	}

//	public ListaPrecios obtenerLP(Document doc) throws ParseException {
//		Element ele = doc.getElementById("ListaPrecios");
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date parsed = format.parse(ele.getAttribute("Fecha"));
//        java.sql.Date fechaSQL = new java.sql.Date(parsed.getTime());
//		ListaPrecios lp = new ListaPrecios(Integer.parseInt(ele.getAttribute("Numero")),fechaSQL,this); 
//		listasDePrecios.add(lp);
//		return lp;
//	}
//
//	public ListaPrecios obtenerLP(Date fechaLP, int nroLP) {
//		ListaPrecios lp = new ListaPrecios(nroLP,fechaLP,this); 
//		listasDePrecios.add(lp);
//		modificar("","",lp.getNumero());
//		return lp;
//	}
	
/*
	public dto.Proveedor toDTO() {
		return new dto.Proveedor(this.condicionesCompra,this.cuit,this.direccion,this.estado,
						this.listasDePrecios,this.LPVigente,this.razonSocial);
	}
*/
}
