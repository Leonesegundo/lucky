package main;
import model.Baralho;
import model.Cartas;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        
        Cartas[] baralhoDeCartas = {
            new Cartas("O sol", 2, false),
            new Cartas("A lua", 3, false ),
            new Cartas("O mago", 4, false)
        };
         
        baralho.adicionarBaralho(baralhoDeCartas);
       
        Cartas[] cartasEmbaralhadas = baralho.baralhoEmbaralhado();

        System.out.println("=== CARTAS EMBARALHADAS E SORTEADAS ===");
        for (Cartas carta : cartasEmbaralhadas) {
            System.out.println("Carta: " + carta.getNome() + 
                               " | ID: " + carta.getId() + 
                               " | Invertida: " + carta.isInvertida());
        }
        
        
        baralho.Tirarcartas(2);
        
        System.out.println("\n=== CARTAS NA MESA ===");
        Cartas[] cartasNaMesa = baralho.getCartasNaMesa();
        for (Cartas carta : cartasNaMesa) {
            System.out.println("Carta: " + carta.getNome() + 
                               " | ID: " + carta.getId() + 
                               " | Invertida: " + carta.isInvertida());
        }
    }
}