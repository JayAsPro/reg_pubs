package sistema_registro.menus;

import java.util.ArrayList;

import reg_pubs.*;
import reg_pubs.tipos.*;

import utilidades.*;
import sistema_registro.*;

public class MenuPublicacao extends MenuOpcoes {
    public MenuPublicacao() {
        super("INSERIR PUBLICAÇÃO",
              new String[] { "Registrar livro",
                             "Registrar revista" });
    }

    private String[] registrarPadrao(RegPubs registro) {
        String nome = Utilidades.lerLinha(" > Nome: ");
        String assunto = Utilidades.lerLinha(" > Assunto: ");
        String edicao = Utilidades.lerLinha(" > Edição: ");
        String editora = Utilidades.lerLinha(" > Editora: ");

        if(registro.buscarEditora(editora) != null) {
            return new String[] {nome, assunto, edicao, editora};
        } else {
            System.out.println("\n>> Editora não encontrada! Registre-a primeiro.");
            Utilidades.pausar();
            return null;
        }

    }

    private void registrarLivro(RegPubs registro) {
        Utilidades.limparTela();
        System.out.println("REGISTRAR LIVRO\n---------------\n");

        String[] infoPadrao = registrarPadrao(registro);

        if(infoPadrao != null) {
            ArrayList<String> autores = new ArrayList<String>();
            int numAutores = Utilidades.lerInt(" > Número de autores: ");

            for(int i = 1; i <= numAutores; i += 1) {
                autores.add(Utilidades.lerLinha("    > Autor " + i + ": "));
            }

            registro.addPublicacao(new Livro(infoPadrao[0], infoPadrao[1], infoPadrao[2], registro.buscarEditora(infoPadrao[3]), autores.toArray(new String[0])));

            System.out.println("\n>> Livro cadastrado!");
            Utilidades.pausar();
        }
    }

    private void registrarRevista(RegPubs registro) {
        Utilidades.limparTela();
        System.out.println("REGISTRAR REVISTA\n------------------\n");

        String[] infoPadrao = registrarPadrao(registro);

        if(infoPadrao != null) {
            String periodicidade = Utilidades.lerLinha(" > Periodicidade: ");

            registro.addPublicacao(new Revista(infoPadrao[0], infoPadrao[1], infoPadrao[2], registro.buscarEditora(infoPadrao[3]), periodicidade));

            System.out.println("\n>> Revista cadastrada!");
            Utilidades.pausar();
        }
    }

    public void executar(RegPubs registro) {
        Publicacao publicacao = null;
        int opcao = this.lerOpcao();

        switch(opcao) {
            case 1:
                this.registrarLivro(registro);
                break;

            case 2:
                this.registrarRevista(registro);
                break;

            default:
                this.errOpcaoInvalida();
        }
    }
}
