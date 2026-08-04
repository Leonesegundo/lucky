package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

    // Método principal
    public static void main(String[] args) {
        new TelaPrincipal();
    }

    // Construtor da tela
    public TelaPrincipal() {

        // Configurações da janela
        setTitle("Sistema - Tela Principal");

        // Tamanho maior da janela
        setSize(1200, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Abre a janela no centro da tela
        setLocationRelativeTo(null);

        // Define o layout da tela
        setLayout(new BorderLayout());

        // Texto no centro da tela
        JLabel labelBoasVindas = new JLabel(
                "Bem-vindo à Tela Principal!",
                SwingConstants.CENTER
        );

        labelBoasVindas.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        // Adiciona o texto no centro
        add(labelBoasVindas, BorderLayout.CENTER);


        // Painel para ficar na parte inferior
        JPanel painelInferior = new JPanel();

        // Alinha os componentes à esquerda
        painelInferior.setLayout(
                new FlowLayout(FlowLayout.LEFT)
        );

        // Cria a caixa de texto
        JTextField caixaTexto = new JTextField(25);

        // Texto que aparece dentro da caixa
        caixaTexto.setToolTipText("Digite algo aqui...");

        // Adiciona a caixa ao painel
        painelInferior.add(caixaTexto);

        // Coloca o painel na parte inferior
        add(painelInferior, BorderLayout.SOUTH);

        // Exibe a janela
        setVisible(true);
    }
}