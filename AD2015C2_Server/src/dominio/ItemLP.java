package dominio;

import entities.ItemLPENT;
import entities.ListaPreciosENT;

public class ItemLP {

	private Rodamiento rodamiento;
	private float precio;
	private int stock;
	private int condCompra;
	private int bonificacion;
//	private List<CondCompra> condicionesCompra;

	public ItemLP(Rodamiento rodamiento, float precio, int stock, int condCompra, int bonificacion) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
//		this.condicionesCompra = new ArrayList<CondCompra>();
//		persistirse();
	}

	public ItemLP() {

	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

//	public List<CondCompra> getCondicionesCompra() {
//		return condicionesCompra;
//	}

//	public void setCondicionesCompra(List<CondCompra> condicionesCompra) {
//		this.condicionesCompra = condicionesCompra;
//	}
/*
	public dto.ItemLP toDTO() {
		return new dto.ItemLP(this.condicionesCompra,this.precio,this.rodamiento,this.stock);
	}
*/

	public int getCondcompra() {
		return condCompra;
	}

	public void setCondcompra(int condCompra) {
		this.condCompra = condCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

//	public void persistirse() {
//		ItemLPENT ilpENT = toENT();
//		HibernateDAO.getInstancia().saveOrUpdate(ilpENT);
//	}

	public ItemLPENT toENT(ListaPreciosENT lpENT) {
//		return new ItemLPENT(rodamiento.toENT(), precio, stock);
		return new ItemLPENT(lpENT, rodamiento.toENT(), precio, stock, condCompra, bonificacion);
	}

//	public void obtenerCondCompra(Element ele) {
//		NodeList nList = ele.getElementsByTagName("CondicionDeCompra");
//		for (int i=0;i < nList.getLength(); i++){
//			if (nList.item(i).hasChildNodes()){
//				Element eleAux = (Element)nList.item(i);
//				CondCompra cc = new CondCompra();
//				cc.setBonificacion(Float.parseFloat(eleAux.getElementsByTagName("Bonificacion").item(0).getTextContent()));
//				cc.setTipo(eleAux.getElementsByTagName("Tipo").item(0).getTextContent());
//				cc.setValor(eleAux.getElementsByTagName("Valor").item(0).getTextContent());
//				cc.persistirse();
//				condicionesCompra.add(cc);
//			}
//		}
//	}
	
}