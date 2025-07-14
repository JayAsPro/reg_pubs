package reg_pubs;

import java.io.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;

import java.util.ArrayList;

public class RegPubs implements Serializable {
    ArrayList<Editora> editoras;
    ArrayList<Publicacao> publicacoes;
    
    public RegPubs() {
        this.editoras = new ArrayList<Editora>();
        this.publicacoes = new ArrayList<Publicacao>();
    }

    public void addEditora(Editora editora) {
        this.editoras.add(editora);
    }
    
    public void addPublicacao(Publicacao publicacao) {
        this.publicacoes.add(publicacao);
    }

    public Editora buscarEditora(String nome) {
        for(Editora editora : this.editoras) {
            if(editora.nome == nome)
                return editora;
        }

        return null;
    }

    public Publicacao buscarPublicacao(String nome) {
        for(Publicacao publicacao : this.publicacoes) {
            if(publicacao.nome == nome)
                return publicacao;
        }

        return null;
    }

    public static RegPubs carregar(String caminhoArquivo) throws IOException, ClassNotFoundException {
        return (RegPubs) new ObjectInputStream(new FileInputStream(caminhoArquivo)).readObject();
    }

    public void salvar(String caminhoArquivo) throws IOException {
        new ObjectOutputStream(new FileOutputStream(caminhoArquivo)).writeObject(this);
    }

    public String toString() {
        String listaConteudo = "";

        for(Editora editora : this.editoras) {
            listaConteudo = listaConteudo + editora.toString() + "\n";
        }

        for(Publicacao publicacao : this.publicacoes) {
            listaConteudo = listaConteudo + publicacao.toString() + "\n";
        }

        return listaConteudo;
    }
}
