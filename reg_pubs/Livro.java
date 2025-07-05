package reg_pubs;

public class Livro extends Publicacao {
    String[] autores;

    public Livro(String nome, String assunto, String edicao, Editora editora, String[] autores) {
        super(nome, assunto, edicao, editora);
        this.autores = autores;
    }

    public String toString() {
        String listaAutores = "";
        for(String autor : this.autores) {
            listaAutores = listaAutores + "\n   " + autor;
        }

        return "LIVRO\n-----\n" + this.toStringPadrao() + "Autores:" + listaAutores + "\n";
    }

    public String[] getAutores() {
        return this.autores;
    }
}
