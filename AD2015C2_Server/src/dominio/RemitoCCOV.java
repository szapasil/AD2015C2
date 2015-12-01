package dominio;

import hbt.HibernateDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.ItemRCCOVENT;
import entities.ItemRPCCENT;
import entities.OrdenDeCompraENT;
import entities.RemitoCCOVENT;
import entities.SolicitudDeCompraENT;
import app.OV;

public class RemitoCCOV {

	private int numero;
	private OV ov;
	private Date fecha;
	private List<SolicitudDeCompra> solicitudesDeCompra;
	private List<ItemRCCOV> items;
	
	public RemitoCCOV(int numero, OV ov, Date fecha,List<SolicitudDeCompra> solicitudesDeCompra, List<ItemRCCOV> items) {
		super();
		this.numero = numero;
		this.ov = ov;
		this.fecha = fecha;
		this.solicitudesDeCompra = solicitudesDeCompra;
		this.items = items;
	}

	public int getNuemero() {
		return numero;
	}

	public void setNuemero(int numero) {
		this.numero = numero;
	}

	public OV getOV() {
		return ov;
	}

	public void setOV(OV ov) {
		this.ov = ov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<SolicitudDeCompra> getSolicitudesDeCompra() {
		return solicitudesDeCompra;
	}

	public void setSolicitudesDeCompra(List<SolicitudDeCompra> solicitudesDeCompra) {
		this.solicitudesDeCompra = solicitudesDeCompra;
	}

	public List<ItemRCCOV> getItems() {
		return items;
	}

	public void setItems(List<ItemRCCOV> items) {
		this.items = items;
	}

	public void persistirse() {
		RemitoCCOVENT rpccENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(rpccENT);
	}

	public RemitoCCOVENT toENT() {
		List<ItemRCCOVENT> itemsENT = new ArrayList<ItemRCCOVENT>();
		List<SolicitudDeCompraENT> scsENT = new ArrayList<SolicitudDeCompraENT>();
		RemitoCCOVENT rccovENT = new RemitoCCOVENT(numero, fecha, ov.toENT());
		for (ItemRCCOV item : items) {
			itemsENT.add(item.toENT(rccovENT));
		}
		rccovENT.setItems(itemsENT);
		for (SolicitudDeCompra sc : solicitudesDeCompra) {
			scsENT.add(sc.toENT());
//			scsENT.add(sc.toENT(rccovENT));?????????
		}
		rccovENT.setSolicitudesDeCompra(scsENT);
		return rccovENT;
	}
}
