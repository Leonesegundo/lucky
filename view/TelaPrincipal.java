package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        
       

        setTitle("Sistema - Tela Principal");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel labelBoasVindas = new JLabel("Bem-vindo à Tela Principal!", SwingConstants.CENTER);
        labelBoasVindas.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelBoasVindas);
    }
}