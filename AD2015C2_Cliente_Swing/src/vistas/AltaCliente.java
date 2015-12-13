package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import delegado.BusinessDelegateCC;
import delegado.BusinessDelegateOV;

public class AltaCliente extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelCuil;
	private JTextField jTextFieldCuil;
	
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	
	private JTextField jTextFieldDireccion;
	private JLabel jLabelDireccion;
	
	private JTextField jTextFieldCondicionIVA;
	private JLabel jLabelCondicionIVA;

	private JTextField jTextFieldCondicionPago;
	private JLabel jLabelCondicionPago;

	private JTextField jTextFieldDescuento;
	private JLabel jLabelDescuento;
	
	private JLabel jLabelPorciento;
	
	private JTextField jTextFieldSucursal;
	private JLabel jLabelSucursal;
	
	private JButton jButtonCancelar;
	private JButton jButtonAceptar;
	
	private static AltaCliente instancia;
	
	public static AltaCliente getInstancia(){
		if(instancia==null)
			instancia = new AltaCliente();
		return null;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaCliente inst = new AltaCliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.getContentPane().setLayout(null);
			}
		});
	}
	
	public AltaCliente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelCuil = new JLabel();
				getContentPane().add(jLabelCuil);
				jLabelCuil.setText("Cuil:");
				jLabelCuil.setBounds(35, 55, 98, 16);
			}
			{
				jTextFieldCuil = new JTextField();
				getContentPane().add(jTextFieldCuil);
				jTextFieldCuil.setBounds(140, 50, 100, 25);
			}
			{
				jLabelRazonSocial = new JLabel();
				getContentPane().add(jLabelRazonSocial);
				jLabelRazonSocial.setText("Razon social:");
				jLabelRazonSocial.setBounds(35, 95, 98, 36);
			}
			{
				jTextFieldRazonSocial = new JTextField();
				getContentPane().add(jTextFieldRazonSocial);
				jTextFieldRazonSocial.setBounds(140, 100, 160, 25);
			}
			{
				jLabelDireccion = new JLabel();
				getContentPane().add(jLabelDireccion);
				jLabelDireccion.setText("Direccion:");
				jLabelDireccion.setBounds(35, 130, 98, 66);
			}
			{
				jTextFieldDireccion = new JTextField();
				getContentPane().add(jTextFieldDireccion);
				jTextFieldDireccion.setBounds(140, 150, 160, 25);
			}
			{
				jLabelCondicionIVA = new JLabel();
				getContentPane().add(jLabelCondicionIVA);
				jLabelCondicionIVA.setText("Condicion IVA:");
				jLabelCondicionIVA.setBounds(35, 180, 98, 66);
			}
			{
				jTextFieldCondicionIVA = new JTextField();
				getContentPane().add(jTextFieldCondicionIVA);
				jTextFieldCondicionIVA.setBounds(140, 200, 160, 25);
			}
			{
				jLabelCondicionPago = new JLabel();
				getContentPane().add(jLabelCondicionPago);
				jLabelCondicionPago.setText("Condicion Pago:");
				jLabelCondicionPago.setBounds(35, 230, 98, 66);
			}
			{
				jTextFieldCondicionPago = new JTextField();
				getContentPane().add(jTextFieldCondicionPago);
				jTextFieldCondicionPago.setBounds(140, 250, 160, 25);
			}
			{
				jLabelDescuento = new JLabel();
				getContentPane().add(jLabelDescuento);
				jLabelDescuento.setText("Descuento:");
				jLabelDescuento.setBounds(35, 280, 98, 66);
			}
			{
				jTextFieldDescuento = new JTextField();
				getContentPane().add(jTextFieldDescuento);
				jTextFieldDescuento.setBounds(140, 300, 30, 25);
			}
			{
				jLabelPorciento = new JLabel();
				getContentPane().add(jLabelPorciento);
				jLabelPorciento.setText("%");
				jLabelPorciento.setBounds(175, 280, 30, 66);
			}			
			{
				jLabelSucursal = new JLabel();
				getContentPane().add(jLabelSucursal);
				jLabelSucursal.setText("Numero de Sucursal:");
				jLabelSucursal.setBounds(35, 355, 150, 66);
			}
			{
				jTextFieldSucursal = new JTextField();
				getContentPane().add(jTextFieldSucursal);
				jTextFieldSucursal.setBounds(170, 375, 30, 25);
			}
			{
				jButtonAceptar = new JButton();
				getContentPane().add(jButtonAceptar);
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setBounds(38, 450, 98, 23);
				jButtonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String cuil = jTextFieldCuil.getText();
						String razonSocial = jTextFieldRazonSocial.getText();
						String direccion = jTextFieldDireccion.getText();
						String condicionIVA = jTextFieldCondicionIVA.getText();
						String condicionPago = jTextFieldCondicionPago.getText();
						float descuento = Float.parseFloat(jTextFieldDescuento.getText());
						int nroSucursal = Integer.parseInt(jTextFieldSucursal.getText());
						
						//LOOKUP SERVICE
						BusinessDelegateOV bdOV = new BusinessDelegateOV();
						bdOV.LookupServiceOV();

						//ALTA DE UN CLIENTE:
						bdOV.altaCliente(razonSocial, direccion, cuil, condicionIVA, condicionPago, descuento, nroSucursal);
						
						jTextFieldCuil.setEnabled(false);
						jTextFieldRazonSocial.setEnabled(false);
						jTextFieldDireccion.setEnabled(false);
						jTextFieldCondicionIVA.setEnabled(false);
						jTextFieldCondicionPago.setEnabled(false);
						jTextFieldDescuento.setEnabled(false);
						jTextFieldSucursal.setEnabled(false);
						jButtonAceptar.setEnabled(false);
						jButtonCancelar.setEnabled(true);
					}
				});
			}
			{
				jButtonCancelar = new JButton();
				getContentPane().add(jButtonCancelar);
				jButtonCancelar.setText("Cancelar");
				jButtonCancelar.setBounds(186, 450, 95, 23);
				jButtonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jTextFieldCuil.setText("");
						jTextFieldRazonSocial.setText("");
						jTextFieldDireccion.setText("");
						jTextFieldCondicionIVA.setText("");
						jTextFieldCondicionPago.setText("");
						jTextFieldDescuento.setText("");
						jTextFieldSucursal.setText("");
						jTextFieldCuil.setEnabled(true);
						jTextFieldRazonSocial.setEnabled(true);
						jTextFieldDireccion.setEnabled(true);
						jTextFieldCondicionIVA.setEnabled(true);
						jTextFieldCondicionPago.setEnabled(true);
						jTextFieldDescuento.setEnabled(true);
						jTextFieldSucursal.setEnabled(true);
					}
				});
			}
			pack();
			this.setSize(350, 550);
			this.setTitle("Alta de Cliente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
