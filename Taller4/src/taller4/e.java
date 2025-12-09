package taller4;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class e {
	static JFrame frame;

    public static void main(String[] args) throws HeadlessException {
    	
    	System.out.println("aña");
    	
        frame = new JFrame("Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(20, 60, 100, 30);
        frame.add(passLabel);

        JPasswordField passInput = new JPasswordField();
        passInput.setBounds(120, 60, 150, 30);
        frame.add(passInput);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(100, 110, 120, 30);
        frame.add(loginButton);

        // Evento al presionar el botón
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

 
                String contrasena = String.valueOf(passInput.getPassword());

                // Aquí iría la validación con tu archivo usuarios.txt
            
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos");
                
            }
        });

        frame.setVisible(true);
    }
}
