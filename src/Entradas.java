import java.util.InputMismatchException;
import java.util.Scanner;

public class Entradas {
    public static int validarInt(Scanner sc, byte max) {
        int valor;
        try {
            valor = sc.nextInt();
        } catch (InputMismatchException e) {
            return 9;

        }

        if (valor < 0 || valor > max) {
            return 9;
        } else {
            return valor;
        }
    }

    public static boolean validarCpf(String cpf) {
        if (cpf.length() != 11) {
            System.out.println("O CPF deve conter 11 dígitos!");
            return false;
        } else return true;
    }


    public static double validarDouble(Scanner sc) {
        double valor;
        try {
            valor = sc.nextDouble();
            if(valor < 0) return 0;
        } catch (InputMismatchException e) {
            return -1;
        }
        return valor;
        }
    }


