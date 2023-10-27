package umu.tds;

import java.awt.EventQueue;

import javax.swing.UIManager;

import umu.tds.vista.ControladorInicio;

public class AppMusic {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
					ControladorInicio window = new ControladorInicio();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
