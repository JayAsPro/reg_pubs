package sistema_registro.menus;

import java.io.IOException;

import utilidades.*;
import reg_pubs.*;
import sistema_registro.*;

public class MenuPrincipal extends MenuOpcoes {
    public MenuPrincipal() {
        super("MENU PRINCIPAL",
              new String[] { "Novo registro de publicações",
                             "Carregar registro de publicações",
                             "Imprimir registro",
                             "Registrar editora",
                             "Registrar publicação",
                             "Salvar e Sair" });
    }

    private void errRegNaoInit() {
        System.out.println("\n>> Registro não inicializado!");
        Utilidades.pausar();
    }

    private void registrarEditora(RegPubs registro) {
        Utilidades.limparTela();
        System.out.println("REGISTRAR EDITORA\n-----------------\n");

        registro.addEditora(new Editora(Utilidades.lerLinha("\n > Nome: "), Utilidades.lerLinha(" > Website: ")));

        System.out.println("\n>> Editora cadastrada!");
        Utilidades.pausar();
    }

    public void executar() {
        RegPubs registro = null;
        String caminhoArquivo = "";
        int opcao = 0;

        do {
            opcao = this.lerOpcao();

            switch(opcao) {
                case 1:
                    caminhoArquivo = Utilidades.lerLinha(" > Nome/caminho do arquivo: ");
                    registro = new RegPubs();
                    System.out.println("\n>> Novo registro criado!");
                    Utilidades.pausar();
                    break;
                case 2:
                    caminhoArquivo = Utilidades.lerLinha(" > Nome/caminho do arquivo: ");

                    try {
                        registro = RegPubs.carregar(caminhoArquivo);
                    } catch(IOException | ClassNotFoundException e) {
                        System.out.println("\n>> Arquivo não encontrado! Tente novamente!");
                        Utilidades.pausar();
                    }
                    break;
                case 3:
                    if(registro != null) {
                        Utilidades.limparTela();
                        System.out.println("[[" + caminhoArquivo + "]]\n\n");
                        System.out.println(registro);
                        Utilidades.pausar();
                    } else {
                        this.errRegNaoInit();
                    }
                    break;
                case 4:
                    if(registro != null) {
                        this.registrarEditora(registro);
                    } else {
                        this.errRegNaoInit();
                    }
                    break;

                case 5:
                    if(registro != null) {
                        new MenuPublicacao().executar(registro);
                    } else {
                        this.errRegNaoInit();
                    }
                    break;

                case 6:
                    if(registro != null) {
                        try {
                            registro.salvar(caminhoArquivo);
                        } catch(IOException e) {
                            System.out.println("\n>> Erro ao salvar o arquivo!");
                            Utilidades.pausar();
                        }
                    } else {
                        this.errRegNaoInit();
                    }

                    Utilidades.limparTela();
                    break;

                default:
                    this.errOpcaoInvalida();
            }
        } while(opcao != 6);
    }
}
