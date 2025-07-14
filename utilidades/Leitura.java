package utilidades;

import java.util.Scanner;

public abstract class Entrada {
    public static String lerPalavra() {
        return new Scanner(System.in).next();
    }

    public static String lerLinha() {
        return new Scanner(System.in).nextLine();
    }

    public static int lerInt() {
        int numero = 0;
        Scanner leitor = new Scanner(System.in);

        if(leitor.hasNextInt()) {
            numero = leitor.nextInt();
        }

        return numero;
    }

    public static float lerFloat() {
        float numero = 0;
        Scanner leitor = new Scanner(System.in);

        if(leitor.hasNextFloat()) {
            numero = leitor.nextFloat();
        }

        return numero;
    }
}
