package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import entities.ItemLPENT;

public class ItemLP {

	private Rodamiento rodamiento;
	private float precio;
	private int stock;
	private List<CondCompra> condicionesCompra;

	public ItemLP(Rodamiento rodamiento, float precio, int stock) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condicionesCompra = new ArrayList<CondCompra>();
		persistirse();
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

	public List<CondCompra> getCondicionesCompra() {
		return condicionesCompra;
	}

	public void setCondicionesCompra(List<CondCompra> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
/*
	public dto.ItemLP toDTO() {
		return new dto.ItemLP(this.condicionesCompra,this.precio,this.rodamiento,this.stock);
	}
*/

	public void persistirse() {
		ItemLPENT ilpENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(ilpENT);
	}

	public ItemLPENT toENT() {
		return new ItemLPENT(rodamiento.toENT(), precio, stock);
	}

	public void obtenerCondCompra(Element ele) {
		NodeList nList = ele.getElementsByTagName("CondicionDeCompra");
		for (int i=0;i < nList.getLength(); i++){
			if (nList.item(i).hasChildNodes()){
				Element eleAux = (Element)nList.item(i);
				CondCompra cc = new CondCompra();
				cc.setBonificacion(Float.parseFloat(eleAux.getElementsByTagName("Bonificacion").item(0).getTextContent()));
				cc.setTipo(eleAux.getElementsByTagName("Tipo").item(0).getTextContent());
				cc.setValor(eleAux.getElementsByTagName("Valor").item(0).getTextContent());
				cc.persistirse();
				condicionesCompra.add(cc);
			}
		}
	}
}