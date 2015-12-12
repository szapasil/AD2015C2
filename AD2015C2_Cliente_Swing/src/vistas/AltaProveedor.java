package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import delegado.BusinessDelegateCC;

public class AltaProveedor extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelCuit;
	private JTextField jTextFieldCuit;
	
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	
	private JTextField jTextFieldDireccion;
	private JLabel jLabelDireccion;
	
	private JButton jButtonCancelar;
	private JButton jButtonAceptar;
	
	private static AltaProveedor instancia;
	
	public static AltaProveedor getInstancia(){
		if(instancia==null)
			instancia = new AltaProveedor();
		return null;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaProveedor inst = new AltaProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.getContentPane().setLayout(null);
			}
		});
	}
	
	public AltaProveedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Cuit:");
				jLabelCuit.setBounds(35, 55, 98, 16);
			}
			{
				jTextFieldCuit = new JTextField();
				getContentPane().add(jTextFieldCuit);
				jTextFieldCuit.setBounds(120, 50, 100, 25);
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
				jTextFieldRazonSocial.setBounds(120, 100, 160, 25);
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
				jTextFieldDireccion.setBounds(120, 150, 160, 25);
			}
			{
				jButtonAceptar = new JButton();
				getContentPane().add(jButtonAceptar);
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setBounds(38, 200, 98, 23);
				jButtonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String cuit = jTextFieldCuit.getText();
						String razonSocial = jTextFieldRazonSocial.getText();
						String direccion = jTextFieldDireccion.getText();
						
						//LOOKUP SERVICE
						BusinessDelegateCC bdCC = new BusinessDelegateCC();
						bdCC.LookupServiceCC();

						//ALTA DE UN PROVEEDOR:
						bdCC.altaProveedor(cuit,razonSocial,direccion);
						
						jTextFieldCuit.setEnabled(false);
						jTextFieldRazonSocial.setEnabled(false);
						jTextFieldDireccion.setEnabled(false);
						jButtonAceptar.setEnabled(false);
						jButtonCancelar.setEnabled(true);
					}
				});
			}
			{
				jButtonCancelar = new JButton();
				getContentPane().add(jButtonCancelar);
				jButtonCancelar.setText("Cancelar");
				jButtonCancelar.setBounds(186, 200, 95, 23);
				jButtonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jTextFieldCuit.setText("");
						jTextFieldRazonSocial.setText("");
						jTextFieldDireccion.setText("");
					}
				});
			}
			pack();
			this.setSize(339, 278);
			this.setTitle("Alta de Proveedor");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
