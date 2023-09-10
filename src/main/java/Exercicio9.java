/*

Leia um valor com duas casas decimais, equivalente ao salário de uma pessoa de Lisarb. Em seguida,
calcule e mostre o valor que esta pessoa deve pagar de Imposto de Renda, segundo a tabela abaixo.

0.00 a 2  k    isento
2k   a 3  k    8%
3k   a 4.5k    18%
       4.5k ++ 28%


Lembre-se que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas sobre R$ 1000.00,
pois a faixa de salário que fica de R$ 0.00 até R$ 2000.00 é isenta de Imposto de Renda. No
exemplo fornecido (abaixo), a taxa é de 8% sobre R$ 1000.00 + 18% sobre R$ 2.00, o que resulta
em R$ 80.36 no total. O valor deve ser impresso com duas casas decimais.

*/

import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.lang3.tuple.Pair;
public class Exercicio9 {

    public static double getSalary(Scanner scanner){
        System.out.println("Digite o salário: ");
        try{
            double salary = scanner.nextDouble();
            if (salary > 0.00){
                return salary;
            }
            else{
                System.out.println("Salário deve ser maior que 0");
                return getSalary(scanner);
            }
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Salário deve ser um número, use ponto ao invés de vírgula");
                scanner.next();
                return getSalary(scanner);
            }
            else{
                System.out.println("Algo deu errado:" + e);
                return getSalary(scanner);
            }
        }
    }

    private static double getTotalTax(Double key, double salary, Pair<Double, Double> range) {
        double taxableSalary = salary - 2000;
        double totalTax;
        if(salary < 4500){
            double firstTax = (taxableSalary - (salary - range.getLeft())) * (key -10) / 100;
            double secondTax = (salary - range.getLeft()) * key / 100;
            totalTax = firstTax + secondTax;
        }
        else{
            taxableSalary = taxableSalary - 1000;
            double firstTax = (taxableSalary - (salary - range.getLeft())) * (key -10) / 100;
            double secondTax = (salary - range.getLeft()) * key / 100;
            totalTax = firstTax + secondTax + 80;
        }
        return totalTax;
    }
    
    public static void main(String [] args) throws RuntimeException{
        HashMap<Double,Pair<Double,Double>> taxPercentage = new HashMap<Double,Pair<Double,Double>>();
        taxPercentage.put(0.0, Pair.of(0.0, 2000.00));
        taxPercentage.put(8.00, Pair.of(2000.01, 3000.00));
        taxPercentage.put(18.00, Pair.of(3000.01, 4500.00));
        taxPercentage.put(28.00, Pair.of(4500.01, Double.MAX_VALUE));

        Scanner scanner = new Scanner(System.in);
        double salary = getSalary(scanner);


        for(Double key : taxPercentage.keySet()) {
            Pair<Double, Double> range = taxPercentage.get(key);
            if (salary >= range.getLeft() && salary <= range.getRight() && key > 0.0) {
                double totalTax = getTotalTax(key, salary, range);

                System.out.printf("Imposto de renda: R$ %.2f\n", totalTax);
                break;
            } else {
                if(salary < 2000.01){
                    System.out.println("Isento de imposto de renda");
                    break;
                }
            }
        }
    }
}
