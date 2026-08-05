package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import model.Baralho;
import model.Cartas;

public class TelaPrincipal extends JFrame {

    // ===== Model =====
    private Baralho baralho;

    // ===== Componentes que precisam ser atualizados dinamicamente =====
    private JPanel painelMesa;          // onde as cartas "na mesa" aparecem
    private JTextField campoQuantidade; // o número no meio dos botões -/+
    private JTextArea areaSuasCartas;   // lista de cartas que o usuário "puxou"

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPrincipal::new);
    }

    public TelaPrincipal() {

        // ---- Configuração básica da janela ----
        setTitle("Sistema - Tela Principal");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---- Model: cria o baralho e já popula com as cartas do wireframe ----
        // TODO: se as cartas vierem de outro lugar (banco, arquivo, etc.),
        // troque esse trecho pela sua fonte real de dados.
        baralho = new Baralho();
        baralho.adicionarBaralho(new Cartas[] {
            new Cartas("THE STAR", 17, false),
            new Cartas("THE MOON", 18, false),
            new Cartas("THE SUN", 19, false),
            new Cartas("TEMPERANCE", 14, false),
            new Cartas("THE STRENGTH", 8, false)
        });

        add(criarPainelMesa(), BorderLayout.CENTER);
        add(criarPainelControle(), BorderLayout.EAST);

        setVisible(true);
    }

    // =========================================================
    // PAINEL ESQUERDO ("Mesa")
    // =========================================================
    private JPanel criarPainelMesa() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Mesa", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.PLAIN, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        container.add(titulo, BorderLayout.NORTH);

        // Grid que vai receber os "cards" (por enquanto, texto - depois dá
        // pra trocar por JLabel com ImageIcon quando você tiver as imagens)
        painelMesa = new JPanel(new GridLayout(0, 3, 20, 20));
        painelMesa.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        painelMesa.setBackground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(painelMesa);
        scroll.setBorder(null);
        container.add(scroll, BorderLayout.CENTER);

        return container;
    }

    // Cria o "cartão" visual de uma carta (placeholder até ter imagens reais)
    private JComponent criarCardVisual(Cartas carta) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(180, 260));
        card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        card.setBackground(Color.WHITE);

        JLabel nome = new JLabel(carta.getNome(), SwingConstants.CENTER);
        nome.setFont(new Font("Serif", Font.BOLD, 14));
        card.add(nome, BorderLayout.SOUTH);

        // TODO: quando tiver as imagens, troque este JLabel central
        // por um JLabel com ImageIcon, e use carta.isInvertida()
        // pra decidir se a imagem deve ser rotacionada/invertida.
        JLabel estado = new JLabel(carta.isInvertida() ? "(invertida)" : "", SwingConstants.CENTER);
        card.add(estado, BorderLayout.CENTER);

        return card;
    }

    // =========================================================
    // PAINEL DIREITO (controles)
    // =========================================================
    private JPanel criarPainelControle() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(new Color(180, 180, 180));
        painel.setPreferredSize(new Dimension(320, getHeight()));
        painel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

        // ---- Linha do contador (- [5] +) ----
        JPanel linhaContador = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        linhaContador.setOpaque(false);

        JButton btnMenos = new JButton("−");
        btnMenos.setBackground(new Color(230, 100, 100));

        campoQuantidade = new JTextField("5", 3);
        campoQuantidade.setFont(new Font("Arial", Font.PLAIN, 18));
        campoQuantidade.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnMais = new JButton("+");
        btnMais.setBackground(new Color(150, 220, 120));

        btnMenos.addActionListener(e -> alterarQuantidade(-1));
        btnMais.addActionListener(e -> alterarQuantidade(1));

        linhaContador.add(btnMenos);
        linhaContador.add(campoQuantidade);
        linhaContador.add(btnMais);

        // ---- Botão Embaralhar ----
        JButton btnEmbaralhar = new JButton("Embaralhar");
        estilizarBotaoGradiente(btnEmbaralhar);
        btnEmbaralhar.addActionListener(e -> embaralhar());

        // ---- Botões +1 / resetar ----
        JPanel linhaAcoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        linhaAcoes.setOpaque(false);

        JButton btnMaisUm = new JButton("+1");
        estilizarBotaoGradiente(btnMaisUm);
        btnMaisUm.addActionListener(e -> puxarUmaCarta());

        JButton btnResetar = new JButton("resetar");
        estilizarBotaoGradiente(btnResetar);
        btnResetar.addActionListener(e -> resetar());

        linhaAcoes.add(btnMaisUm);
        linhaAcoes.add(btnResetar);

        // ---- "Suas Cartas:" ----
        JLabel labelSuasCartas = new JLabel("Suas Cartas :");
        labelSuasCartas.setFont(new Font("Arial", Font.PLAIN, 16));
        labelSuasCartas.setAlignmentX(Component.LEFT_ALIGNMENT);

        areaSuasCartas = new JTextArea();
        areaSuasCartas.setEditable(false);
        JScrollPane scrollCartas = new JScrollPane(areaSuasCartas);
        scrollCartas.setPreferredSize(new Dimension(260, 300));

        // ---- Monta tudo, centralizado, com espaçamento ----
        painel.add(centralizar(linhaContador));
        painel.add(Box.createVerticalStrut(20));
        painel.add(centralizar(btnEmbaralhar));
        painel.add(Box.createVerticalStrut(20));
        painel.add(centralizar(linhaAcoes));
        painel.add(Box.createVerticalStrut(25));
        painel.add(labelSuasCartas);
        painel.add(Box.createVerticalStrut(10));
        painel.add(scrollCartas);

        return painel;
    }

    private JComponent centralizar(JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        return c;
    }

    private void estilizarBotaoGradiente(JButton botao) {
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(110, 110, 200));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
    }

    // =========================================================
    // AÇÕES (ligação com o Baralho)
    // =========================================================

    private void alterarQuantidade(int delta) {
        int atual = lerQuantidade();
        int novo = Math.max(0, atual + delta);
        campoQuantidade.setText(String.valueOf(novo));
    }

    private int lerQuantidade() {
        try {
            return Integer.parseInt(campoQuantidade.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void embaralhar() {
        Cartas[] embaralhadas = baralho.baralhoEmbaralhado();
        atualizarPainelMesa(embaralhadas);
    }

    private void puxarUmaCarta() {
        // TODO: decida a regra aqui. Exemplo simples: puxa 1 carta do
        // baralho embaralhado e mostra na lista "Suas Cartas".
        baralho.Tirarcartas(1);
        atualizarListaSuasCartas(baralho.getCartasNaMesa());
    }

    private void resetar() {
        // TODO: defina o que "resetar" significa no seu jogo:
        // - só limpar a mesa e a lista visualmente?
        // - recriar o Baralho do zero (baralho = new Baralho(); ...)?
        campoQuantidade.setText("5");
        areaSuasCartas.setText("");
        painelMesa.removeAll();
        painelMesa.revalidate();
        painelMesa.repaint();
    }

    private void atualizarPainelMesa(Cartas[] cartas) {
        painelMesa.removeAll();
        for (Cartas carta : cartas) {
            painelMesa.add(criarCardVisual(carta));
        }
        painelMesa.revalidate();
        painelMesa.repaint();
    }

    private void atualizarListaSuasCartas(Cartas[] cartas) {
        StringBuilder sb = new StringBuilder();
        for (Cartas carta : cartas) {
            sb.append(carta.getNome())
              .append(carta.isInvertida() ? " (invertida)" : "")
              .append("\n");
        }
        areaSuasCartas.setText(sb.toString());
    }
}