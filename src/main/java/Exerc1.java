import java.util.Scanner;

public class Exerc1 {


    public static double getTempoConsumido(Scanner scanner){
        System.out.println("Digite o tempo consumido: ");
        try{
            double tempo = scanner.nextDouble();
            if(tempo < 0){throw new Exception("Tempo não pode ser negativo");}
            return tempo;
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Tempo deve ser um número");
                scanner.next();
                return getTempoConsumido(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getTempoConsumido(scanner);
            }
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double tempo = getTempoConsumido(scanner);
        double valorPagar = 0;
        if(tempo > 50){
            valorPagar = 50 + (tempo - 100) * 2;
        }
        else{
            valorPagar = 50.00;
        }

        System.out.println("Valor a pagar: " + valorPagar);

        }
    }

