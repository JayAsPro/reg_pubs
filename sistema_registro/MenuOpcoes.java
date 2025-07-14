package sistema_registro;

import utilidades.*;

public abstract class MenuOpcoes {
    String titulo;
    String[] opcoes;

    public MenuOpcoes(String titulo, String[] opcoes) {
        this.titulo = titulo;
        this.opcoes = opcoes;
    }

    public String toString() {
        String separador = "\n" + "-".repeat(this.titulo.length());

        int i = 1;
        String listaOpcoes = "";

        for(String opcao : this.opcoes) {
            listaOpcoes += "\n" + i + ". " + opcao;
            i += 1;
        }

        return titulo + separador + listaOpcoes;
    }

    public int lerOpcao() {
        Utilidades.limparTela();
        System.out.print(this + "\n\n");

        return Utilidades.lerInt(" > Escolha uma opção: ");
    }

    public void errOpcaoInvalida() {
        System.out.println("\n>> Opção inválida! Tente novamente!");
        Utilidades.pausar();
    }
}
