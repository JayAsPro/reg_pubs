package reg_pubs;

import java.io.Serializable;

public class Editora implements Serializable {
    public String nome;
    public String website;
    private int numPubs;
    
    public Editora(String nome, String website) {
        this.nome = nome;
        this.website = website;
        this.numPubs = 0;
    }
    public String toString() {
        return "EDITORA\n-------\nNome: " + this.nome + "\nWebsite: " + this.website + "\n";
    }

    public int getNumPubs() {
        return this.numPubs;
    }

    void adicionarPub() {
        this.numPubs += 1;
    }
}
