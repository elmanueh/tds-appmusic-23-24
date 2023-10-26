package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class ControladorInicio extends JFrame {

	private CardLayout cardLayout;
	private JPanel cardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorInicio window = new ControladorInicio();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControladorInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		  
		cardLayout = new CardLayout();
		VentanaLogin ventanaLogin = new VentanaLogin();
		cardPanel = new JPanel(cardLayout);

		cardPanel.add(ventanaLogin, "ventanaLogin");
		add(cardPanel);
		cardLayout.show(cardPanel, "ventanaLogin");
		
		
		setTitle("Aplicación de Música");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
	}

}
