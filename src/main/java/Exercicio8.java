/*

Você deve fazer um programa que leia um valor qualquer e apresente uma mensagem dizendo em qual
dos seguintes intervalos ([0,25], [25,50], [50,75], [75,100]) este valor se encontra. Obviamente se o
valor não estiver em nenhum destes intervalos, deverá ser impressa a mensagem “Fora de intervalo”.

*/

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio8 {

    public static double getNumber(Scanner scanner){
        System.out.println("Digite um número: ");
        try{
            return scanner.nextDouble();
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Número deve ser um número, use ponto ao invés de vírgula");
                scanner.next();
                return getNumber(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getNumber(scanner);
            }
        }
    }

    public static void main(String [] args){
        HashMap<Double, Double> ranges = new HashMap<Double, Double>();
        ranges.put(0.0, 25.0);
        ranges.put(25.0, 50.0);
        ranges.put(50.0, 75.0);
        ranges.put(75.0, 100.0);

        Scanner scanner = new Scanner(System.in);
        double number = getNumber(scanner);

        for (Double key : ranges.keySet()) {
            if(number >= key && number <= ranges.get(key)){
                System.out.println("O número " + number + " está no intervalo " + key + " -> " + ranges.get(key));
                return;
            }
        }

        System.out.println("O número " + number + " não está em nenhum dos intervalos");
    }
}
