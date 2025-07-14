import java.io.IOException;

import reg_pubs.*;
import reg_pubs.tipos.*;

public class Principal {
    public static void main(String[] args) {
        Editora oreilly = new Editora("O'Reilly", "http://oreilly.com/");
        String [] autores = {"Eric Freeman", "Elisabeth Freeman"};
        Publicacao headfirst = new Livro("Padrões de Projeto", "Programação", "2a", oreilly, autores);
        Editora tres = new Editora("Editora Três", "http://editora3.terra.com.br/");
        Publicacao oracle = new Revista("Isto É", "Notícias", "2279", tres, "semanal");

        Publicacao html5 = new Livro("HTML5 Pocket Reference", "Programação", "5a", oreilly, new String [] {"Jennifer Robbins"});

        System.out.println("O'Reilly: " + oreilly.getNumPubs() + "\nEditora Três: " + tres.getNumPubs() + "\n\n");

        RegPubs registro = new RegPubs();

        registro.addEditora(oreilly);
        registro.addEditora(tres);

        registro.addPublicacao(headfirst);
        registro.addPublicacao(oracle);
        registro.addPublicacao(html5);

        System.out.println(registro);

        try {
            registro.salvar("reg.pubs");
        } catch(IOException e) {

        }

        try {
            RegPubs registro2 = RegPubs.carregar("reg.pubs");
            System.out.println(registro2);
        } catch(IOException | ClassNotFoundException e) {

        }
    }
}
