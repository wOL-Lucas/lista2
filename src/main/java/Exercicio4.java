/*
Escreva um programa para ler 2 valores (considere que não serão informados valores iguais) e escrever
o maior deles.
*/

import java.util.Scanner;
public class Exercicio4 {

    public static double getParameter(Scanner scanner){
        try{
            return scanner.nextDouble();
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Valor deve ser um número");
                scanner.next();
                return getParameter(scanner);
            }
            throw e;
        }
    }

    public static boolean isGreater(double v1, double v2){
        if(v1 > v2) return true;

        return false;

    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        double v1 = getParameter(scanner);
        System.out.println("Digite o segundo valor: ");
        double v2 = getParameter(scanner);

        if(v1 != v2) {
            boolean isGreater = isGreater(v1, v2);
            if(isGreater){
                System.out.println("O maior valor é: " + v1);
            }
            else{
                System.out.println("O maior valor é: " + v2);
            }
        }
        else{
            System.out.println("Os valores são iguais");
        }

    }

}
