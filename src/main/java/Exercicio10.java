/*
Escreva um programa que recebe como entrada a data de nascimento do usuário, e informa qual o
seu signo.
*/

import java.util.Scanner;
import java.util.HashMap;
public class Exercicio10 {
    public static int[] getDate(Scanner scanner){
        System.out.println("Digite a data de nascimento no formato dd/mm/aaaa: ");
        try{
            String date = scanner.next();
            String[] dateArray = date.split("/");
            int[] dateInt = new int[3];
            for(int i = 0; i < dateArray.length; i++){
                dateInt[i] = Integer.parseInt(dateArray[i]);
            }
            return dateInt;
        }
        catch(Exception e){
            if(e instanceof java.lang.NumberFormatException){
                System.out.println("Data deve ser no formato dd/mm/aaaa");
                return getDate(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getDate(scanner);
            }
        }
    }

    public static void main(String[]args){
        int[] dates = getDate(new Scanner(System.in));
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Capricórnio");
        map.put(2, "Aquário");
        map.put(3, "Peixes");
        map.put(4, "Áries");
        map.put(5, "Touro");
        map.put(6, "Gêmeos");
        map.put(7, "Câncer");
        map.put(8, "Leão");
        map.put(9, "Virgem");
        map.put(10, "Libra");
        map.put(11, "Escorpião");
        map.put(12, "Sagitário");

        try{
            System.out.println("Seu signo é: " + map.get(dates[1]));
        }
        catch(Exception e){
            if(e instanceof java.lang.NullPointerException){
                System.out.println("Data inválida");
            }
            else{
                System.out.println("Algo deu errado:\n" + e);
            }
        }

    }

}
