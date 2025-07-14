package reg_pubs;

import java.io.Serializable;

public abstract class Publicacao implements Serializable {
    public String nome;
    public String assunto;
    public String edicao;
    public Editora editora;
    
    public Publicacao(String nome, String assunto, String edicao, Editora editora) {
        this.nome = nome;
        this.assunto = assunto;
        this.edicao = edicao;
        this.editora = editora;
        this.editora.incPublicacao();
    }

    protected String toStringPadrao() {
        return "Nome: " + this.nome + "\nAssunto: " + this.assunto + "\nEdição: " + this.edicao + "\nEditora: " + this.editora.nome + "\n";
    }

    public abstract String toString();
}
