/*
Escreva um programa para ler um valor e escrever se é positivo ou negativo. Considere o valor zero
como positivo
*/

import java.util.Scanner;
public class Exercicio2 {

    public static boolean isPositive(double value){
        if(value >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static double getParameters(Scanner scanner) {
        System.out.println("Digite um número para verificacao: ");
        try {
            return scanner.nextDouble();

        } catch (Exception e) {
            if (e instanceof java.util.InputMismatchException) {
                System.out.println("Valor deve ser um número");
                scanner.next();
                return getParameters(scanner);
            }
            throw e;
        }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double getParameters = getParameters(scanner);

        if(isPositive(getParameters)){
            System.out.println("O número é positivo");
        }
        else{
            System.out.println("O número é negativo");
        }

    }

}
