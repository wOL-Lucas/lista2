/*
leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo
pode começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24
horas.
*/
import java.util.Scanner;

import static java.lang.Math.round;


public class Exercicio6{

    public static double[] getTimes(Scanner scanner) {
        double[] times = new double[2];
        String[] frases = {"Digite a hora inicial: ", "Digite a hora final: "};
        int i = 0;

        while (i <= 1) {
            System.out.println(frases[i]);
            try {
                String horaInicial = scanner.nextLine();
                String[] horaInicialArray = horaInicial.split(":");
                if (horaInicialArray.length != 2) {
                    throw new Exception("Hora inicial deve ser no formato HH:mm");
                } else if (Double.parseDouble(horaInicialArray[0]) < 0 || Double.parseDouble(horaInicialArray[0]) > 24 || Double.parseDouble(horaInicialArray[1]) > 59 || Double.parseDouble(horaInicialArray[1]) < 0) {
                    throw new Exception("Hora inicial deve ser entre 0 e 24 e os minutos entre 0 e 60");
                }

                times[i] = Double.parseDouble(horaInicialArray[0]) * 60 + Double.parseDouble(horaInicialArray[1]);
                i +=1;

            } catch (Exception e) {
                if (e instanceof java.lang.NumberFormatException) {
                    System.out.println("Hora inicial deve ser um número");
                    scanner.next();
                    return getTimes(scanner);
                } else {
                    System.out.println("Algo deu errado: " + e);
                    return getTimes(scanner);
                }
            }
        }
        return times;
    }

    public static String CalculateTime(double[] times){
        double initialTime,finalTime,minutes,totalHours;
        initialTime = times[0] / 60;
        finalTime = times[1] / 60;



        if(finalTime == initialTime){
            totalHours = 24;
        } else if (finalTime < initialTime) {
            totalHours = 24 + (finalTime - initialTime);
        }
        else{
            totalHours = finalTime - initialTime;
        }

        String [] totalHoursArray = String.valueOf(totalHours).split("\\.");
        if(Double.parseDouble(totalHoursArray[1]) > 0.01){
            minutes = round((Double.parseDouble(totalHoursArray[1]) * 0.6 + 3) / 100) * 100;
            return totalHoursArray[0] + ":" + String.format("%.0f", minutes).substring(0,2) + "h";
        }

        return String.format("%.2f", totalHours);
    }

    public static void main(String [] args){
        double[] horas = getTimes(new Scanner(System.in));
        System.out.println("A quantidade de horas jogadas e: " + CalculateTime(horas));


    }

}