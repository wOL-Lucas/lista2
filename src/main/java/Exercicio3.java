/*
Reescreva o programa do exercício anterior considerando o zero como neutro, ou seja, se for digitado
o valor zero, escrever a palavra zero
*/

import java.util.Scanner;
public class Exercicio3 {

    public static boolean isPositive(double value) {
        if (value > 0) {
            return true;
        } else {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double getParameters = getParameters(scanner);

        if(isPositive(getParameters)){
            System.out.println("O número é positivo");
        }
        else{
            if(getParameters == 0){
                System.out.println("zero");
            }else {
                System.out.println("O número é negativo");
            }
        }
    }
}