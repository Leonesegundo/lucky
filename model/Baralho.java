package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

    // Atributos principais com os seus nomes originais
    private List<Cartas> cartas;
    private List<Cartas> baralhoEmbaralhado;
    private List<Cartas> baralhoNaMesa;

    public Baralho() {
        this.cartas = new ArrayList<>();
        this.baralhoEmbaralhado = new ArrayList<>();
        this.baralhoNaMesa = new ArrayList<>();
    }

    public void adicionarCarta(Cartas carta) {
        cartas.add(new Cartas(carta.getNome(), carta.getId(), carta.isInvertida()));
    }

    public void adicionarBaralho(Cartas[] arrayDeCartas) {
        this.cartas = new ArrayList<>(Arrays.asList(arrayDeCartas));
    }

    // Preenche e embaralha a lista 'baralhoEmbaralhado'
    public Cartas[] baralhoEmbaralhado() {
        this.baralhoEmbaralhado = new ArrayList<>(this.cartas);
        Random random = new Random();

        // Embaralha a ordem da lista
        Collections.shuffle(this.baralhoEmbaralhado);

        // Sorteia aleatoriamente a propriedade 'invertida' de cada carta
        for (Cartas carta : this.baralhoEmbaralhado) {
            carta.setInvertida(random.nextBoolean());
        }

        return this.baralhoEmbaralhado.toArray(new Cartas[0]);
    }

    public void removerCarta(Cartas carta) {
        cartas.remove(carta);
    }

    // Tira cartas do 'baralhoEmbaralhado' e manda para o 'baralhoNaMesa'
    public void Tirarcartas(int quantidade) {
        if (quantidade <= baralhoEmbaralhado.size()) {

            for (int i = 0; i < quantidade; i++) {
                // Remove do topo do baralho embaralhado
                Cartas cartaRemovida = baralhoEmbaralhado.remove(0);

                // Adiciona na mesa
                baralhoNaMesa.add(cartaRemovida);
            }

        } else {
            System.out.println("Não há cartas suficientes no baralho embaralhado.");
        }
    }

    // Getters retornando Arrays (Cartas[]) conforme você definiu
    public Cartas[] getBaralhoEmbaralhado() {
        return baralhoEmbaralhado.toArray(new Cartas[0]);
    }

    public Cartas[] getCartasNaMesa() {
        return baralhoNaMesa.toArray(new Cartas[0]);
    }

    public List<Cartas> getCartas() {
        return cartas;
    }
}