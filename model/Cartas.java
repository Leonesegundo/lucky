package model;

public class Cartas {
    
   private String nome;
    private int id;
    private boolean invertida;

    public Cartas(String nome, int id, boolean invertida) {
        this.nome = nome;
        this.id = id;
        this.invertida = invertida;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean isInvertida() {
        return invertida;
    }

    public void setInvertida(boolean invertida) {
        this.invertida = invertida;
    }

}