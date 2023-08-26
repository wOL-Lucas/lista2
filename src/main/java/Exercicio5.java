/*
As maçãs custam R$ 0,50 cada se forem compradas menos do que uma dúzia, e R$ 0,40 se forem
compradas pelo menos doze. Escreva um programa que leia o número de maçãs compradas, calcule e
escreva o valor total da compra.
*/

import java.util.Scanner;
public class Exercicio5 {
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

    public static void calculate(Scanner scanner){

        System.out.println("Digite a quantidade de maçãs compradas: ");
        double quantidade = getParameter(scanner);
        double valorTotal = 0;
        if(quantidade < 12){
            valorTotal = quantidade * 0.50;
        }
        else{
            valorTotal = quantidade * 0.40;
        }
        System.out.printf("Valor total da compra: %.2f%n", valorTotal);
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        calculate(scanner);
    }
}
