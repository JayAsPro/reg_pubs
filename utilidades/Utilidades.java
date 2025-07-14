package utilidades;

import java.util.Scanner;

public abstract class Utilidades {
    public static void limparTela() {
        System.out.print("\033c\033[H");
    }

    public static void pausar() {
        System.out.print("\n>> Pressione ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }

    public static String lerPalavra(String mensagem) {
        System.out.print("\n" + mensagem);
        return new Scanner(System.in).next();
    }

    public static String lerLinha(String mensagem) {
        System.out.print("\n" + mensagem);
        return new Scanner(System.in).nextLine();
    }

    public static int lerInt(String mensagem) {
        int numero = 0;
        Scanner leitor = new Scanner(System.in);

        System.out.print(mensagem);

        if(leitor.hasNextInt()) {
            numero = leitor.nextInt();
        }

        return numero;
    }

    public static float lerFloat(String mensagem) {
        float numero = 0;
        Scanner leitor = new Scanner(System.in);

        System.out.print("\n" + mensagem);

        if(leitor.hasNextFloat()) {
            numero = leitor.nextFloat();
        }

        return numero;
    }
}
