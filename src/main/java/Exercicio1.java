
/*Escreva um programa que leia o código de origem de um produto e imprima na tela a região de sua
procedência conforme a tabela abaixo:*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio1 {

    public static double getCodigo(Scanner scanner){
        System.out.println("Digite o código do produto: ");
        try{
            return scanner.nextDouble();
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Código deve ser um número");
                scanner.next();
                return getCodigo(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getCodigo(scanner);
            }
        }
    }

    public static String getRegiao(double id){
        HashMap<Double, String> map = new HashMap<Double, String>();
        map.put(1.0, "Sul");
        map.put(2.0, "Norte");
        map.put(3.0, "Leste");
        map.put(4.0, "Oeste");
        map.put(5.0, "Nordeste");
        map.put(6.0,"Nordeste");
        map.put(7.0,"Sudeste");
        map.put(8.0,"Sudeste");
        map.put(9.0,"Sudeste");
        map.put(10.0,"Centro-Oeste");
        map.put(11.0,"Noroeste");

        try {
            if(map.get(id) == null){throw new NullPointerException();}
            return map.get(id);

        }
        catch (Exception e) {
            if (e instanceof java.lang.NullPointerException) {
                return "Produto importado";
            }
            else{
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double codigo = getCodigo(scanner);
        System.out.println(getRegiao(codigo));
    }
}
