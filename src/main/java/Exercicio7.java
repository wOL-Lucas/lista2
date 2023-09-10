/*
Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste
item. A seguir, calcule e mostre o valor da conta a pagar.

1     cachorro quente  4.00
2     x-salada         4.50
3     x-bacon          5.00
4     torrada simples  2.00
5     refrigerante     1.50


*/


import java.util.Dictionary;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.commons.lang3.tuple.Pair;
public class Exercicio7 {

    public static int getProductCode(Scanner scanner){
        System.out.println("Digite o código do produto: ");
        try{
            return scanner.nextInt();
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Código deve ser um número inteiro");
                scanner.next();
                return getProductCode(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getProductCode(scanner);
            }
        }
    }

    public static int getProductQuantity(Scanner scanner){
        System.out.println("Digite a quantidade do produto: ");
        try{
            return scanner.nextInt();
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Quantidade deve ser um número inteiro");
                scanner.next();
                return getProductQuantity(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getProductQuantity(scanner);
            }
        }
    }

    public static Pair<String,Double> getProductPrice(int codigo, HashMap<Integer, Pair<String,Double>> map){
        try {
            return map.get(codigo);
        }
        catch(Exception e){
            if(e instanceof NullPointerException){
                System.out.println("Código não encontrado");
                return null;
            }
            else{
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String [] args) throws RuntimeException{


        HashMap<Integer, Pair<String,Double>> map = new HashMap<Integer,Pair<String,Double>>();
        map.put(1,Pair.of("cachorro quente",4.00));
        map.put(2,Pair.of("x-salada",4.50));
        map.put(3,Pair.of("x-bacon",5.00));
        map.put(4,Pair.of("torrada simples",2.00));
        map.put(5,Pair.of("refrigerante",1.50));

        Scanner scanner = new Scanner(System.in);
        int codigo = getProductCode(scanner);
        int quantidade = getProductQuantity(scanner);

        Pair<String,Double> produto = getProductPrice(codigo, map);
        try{
            String nomeProduto = produto.getLeft();
            Double preco = produto.getRight();
            System.out.printf("Você comprou " + quantidade + " "+ nomeProduto + "\nTotal: R$ %.2f%n",(preco * Double.parseDouble(Integer.toString(quantidade))));
        }
        catch(Exception e){
            if(e instanceof NullPointerException){
                System.out.println("Produto não encontrado, tente novamente");
                main(args);
            }
            else{
                throw new RuntimeException(e);
            }
        }
    }
}
