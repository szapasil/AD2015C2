package dominio;

import javax.persistence.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import dominio.DAO.ProveedorDAO;

@Entity
@Table(name="proveedores")
public class Proveedor {
	
	private String razonSocial;
	private String direccion;
	@Id
	private String cuil;
	private String condicionesPago;
	private float descuento;
	private String condicionesCompra;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="listaPrecios")
	private ListaPrecios listaPrecios;
	private String estado;


	public Proveedor(String razonSocial,String direccion,String cuil,String condicionesPago,float descuento,
					 String condicionesCompra) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cuil = cuil;
		this.condicionesPago = condicionesPago;
		this.descuento = descuento;
		this.condicionesCompra = condicionesCompra;
		this.listaPrecios = new ListaPrecios();
		this.estado = "activo";
	}
	
	public Proveedor()
	{
		
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

	public String getCondicionesPago() {
		return condicionesPago;
	}

	public void setCondicionesPago(String condicionesPago) {
		this.condicionesPago = condicionesPago;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getCondicionesCompra() {
		return condicionesCompra;
	}

	public void setCondicionesCompra(String condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}

	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
//	public ProveedorTO getProveedorTO() {
//		List<ListaPreciosTO> ItemsLPTO = new ArrayList<ListaPreciosTO>(); 
//		for(ListaPrecios lp:listasPrecios)
//			ItemsLPTO.add(lp.getListaPreciosTO());
//		return new ProveedorTO(razonSocial,direccion,cuil,condicionesPago,descuento,condicionesCompra,ItemsLPTO,estado);
//	}

	// MR0306 - Cambio la forma en la que se realiza la busqueda de Proveedores en BD ya que antes se traia toda la lista
	public static Proveedor buscarProveedorDAO(String cuil) {
		return ProveedorDAO.getInstancia().BuscarProveedor(cuil);
	}
	
	public void recuperarLP(Document doc) {
		ListaPrecios lp = new ListaPrecios();
		NodeList nList = doc.getElementsByTagName("ListaPrecios");
		for (int i=0;i < nList.getLength(); i++){
			if (nList.item(i).hasChildNodes())
				lp.setProveedor(this);								
		}
		setListaPrecios(lp);
		lp.insertDAO();
	}	

}
