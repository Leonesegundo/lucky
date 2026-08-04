package main;
import model.Baralho;
import model.Cartas;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        
        Cartas[] baralhoDeCartas = {
            new Cartas("O Louco", 0, false),
            new Cartas("O Mago", 1, false),
            new Cartas("A Sacerdotisa", 2, false),
            new Cartas("A Imperatriz", 3, false),
            new Cartas("O Imperador", 4, false),
            new Cartas("O Hierofante", 5, false),
            new Cartas("Os Enamorados", 6, false),
            new Cartas("O Carro", 7, false),
            new Cartas("A Força", 8, false),
            new Cartas("O Eremita", 9, false),
            new Cartas("A Roda da Fortuna", 10, false),
            new Cartas("A Justiça", 11, false),
            new Cartas("O Enforcado", 12, false),
            new Cartas("A Morte", 13, false),
            new Cartas("A Temperança", 14, false),
            new Cartas("O Diabo", 15, false),
            new Cartas("A Torre", 16, false),
            new Cartas("A Estrela", 17, false),
            new Cartas("A Lua", 18, false),
            new Cartas("O Sol", 19, false),
            new Cartas("O Julgamento", 20, false),
            new Cartas("O Mundo", 21, false),

            // PAUS
            new Cartas("Ás de Paus", 22, false),
            new Cartas("Dois de Paus", 23, false),
            new Cartas("Três de Paus", 24, false),
            new Cartas("Quatro de Paus", 25, false),
            new Cartas("Cinco de Paus", 26, false),
            new Cartas("Seis de Paus", 27, false),
            new Cartas("Sete de Paus", 28, false),
            new Cartas("Oito de Paus", 29, false),
            new Cartas("Nove de Paus", 30, false),
            new Cartas("Dez de Paus", 31, false),
            new Cartas("Pajem de Paus", 32, false),
            new Cartas("Cavaleiro de Paus", 33, false),
            new Cartas("Rainha de Paus", 34, false),
            new Cartas("Rei de Paus", 35, false),

            // COPAS
            new Cartas("Ás de Copas", 36, false),
            new Cartas("Dois de Copas", 37, false),
            new Cartas("Três de Copas", 38, false),
            new Cartas("Quatro de Copas", 39, false),
            new Cartas("Cinco de Copas", 40, false),
            new Cartas("Seis de Copas", 41, false),
            new Cartas("Sete de Copas", 42, false),
            new Cartas("Oito de Copas", 43, false),
            new Cartas("Nove de Copas", 44, false),
            new Cartas("Dez de Copas", 45, false),
            new Cartas("Pajem de Copas", 46, false),
            new Cartas("Cavaleiro de Copas", 47, false),
            new Cartas("Rainha de Copas", 48, false),
            new Cartas("Rei de Copas", 49, false),

            // ESPADAS
            new Cartas("Ás de Espadas", 50, false),
            new Cartas("Dois de Espadas", 51, false),
            new Cartas("Três de Espadas", 52, false),
            new Cartas("Quatro de Espadas", 53, false),
            new Cartas("Cinco de Espadas", 54, false),
            new Cartas("Seis de Espadas", 55, false),
            new Cartas("Sete de Espadas", 56, false),
            new Cartas("Oito de Espadas", 57, false),
            new Cartas("Nove de Espadas", 58, false),
            new Cartas("Dez de Espadas", 59, false),
            new Cartas("Pajem de Espadas", 60, false),
            new Cartas("Cavaleiro de Espadas", 61, false),
            new Cartas("Rainha de Espadas", 62, false),
            new Cartas("Rei de Espadas", 63, false),

            // OUROS
            new Cartas("Ás de Ouros", 64, false),
            new Cartas("Dois de Ouros", 65, false),
            new Cartas("Três de Ouros", 66, false),
            new Cartas("Quatro de Ouros", 67, false),
            new Cartas("Cinco de Ouros", 68, false),
            new Cartas("Seis de Ouros", 69, false),
            new Cartas("Sete de Ouros", 70, false),
            new Cartas("Oito de Ouros", 71, false),
            new Cartas("Nove de Ouros", 72, false),
            new Cartas("Dez de Ouros", 73, false),
            new Cartas("Pajem de Ouros", 74, false),
            new Cartas("Cavaleiro de Ouros", 75, false),
            new Cartas("Rainha de Ouros", 76, false),
            new Cartas("Rei de Ouros", 77, false),
                   
        };
         
        baralho.adicionarBaralho(baralhoDeCartas);
        Cartas[] cartasEmbaralhadas = baralho.baralhoEmbaralhado();    
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