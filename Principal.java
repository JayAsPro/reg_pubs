import reg_pubs.*;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Editora oreilly = new Editora("O'Reilly", "http://oreilly.com/");
        String [] autores = {"Eric Freeman", "Elisabeth Freeman"};
        Publicacao headfirst = new Livro("Padrões de Projeto", "Programação", "2a", oreilly, autores);
        Editora tres = new Editora("Editora Três", "http://editora3.terra.com.br/");
        Publicacao oracle = new Revista("Isto É", "Notícias", "2279", tres, "semanal");

        Publicacao html5 = new Livro("HTML5 Pocket Reference", "Programação", "5a", oreilly, new String [] {"Jennifer Robbins"});

        System.out.println("O'Reilly: " + oreilly.getNumPubs() + "\nEditora Três: " + tres.getNumPubs() + "\n\n");

        RegPubs reg = new RegPubs();

        reg.addEditora(oreilly);
        reg.addEditora(tres);

        reg.addPublicacao(headfirst);
        reg.addPublicacao(oracle);
        reg.addPublicacao(html5);

        System.out.println(reg);

        reg.salvar("reg.pubs");

        RegPubs registro = RegPubs.carregar("reg.pubs");
        System.out.println(registro);
    }
}
