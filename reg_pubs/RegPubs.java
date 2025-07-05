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
    
    public static RegPubs carregar(String caminhoArquivo) {
        RegPubs reg = null;

        try(ObjectInputStream registro = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            reg = (RegPubs) registro.readObject();
        } catch(IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reg;
    }

    public void salvar(String caminhoArquivo) {
        try(ObjectOutputStream registro = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            registro.writeObject(this);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String listaConteudo = "[[REGISTRO DE PUBLICAÇÕES]]\n\n";

        for(Editora editora : this.editoras) {
            listaConteudo = listaConteudo + editora.toString() + "\n";
        }

        for(Publicacao publicacao : this.publicacoes) {
            listaConteudo = listaConteudo + publicacao.toString() + "\n";
        }

        return listaConteudo;
    }
}
