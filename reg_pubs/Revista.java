package reg_pubs;

public class Revista extends Publicacao {
    String periodicidade;

    public Revista(String nome, String assunto, String edicao, Editora editora, String periodicidade) {
        super(nome, assunto, edicao, editora);
        this.periodicidade = periodicidade;
    }

    public String toString() {
        return "REVISTA\n-------\n" + this.toStringPadrao() + "Periodicidade:" + this.periodicidade + "\n";
    }
}
