package umu.tds.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JPanel {
	
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JButton iniciarSesionButton;

    public VentanaLogin() {
        setLayout(new GridLayout(3, 2));

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioField = new JTextField();

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField();

        iniciarSesionButton = new JButton("Iniciar Sesión");

        add(usuarioLabel);
        add(usuarioField);
        add(contrasenaLabel);
        add(contrasenaField);
        add(new JLabel()); // Espacio en blanco
        add(iniciarSesionButton);
    }
}