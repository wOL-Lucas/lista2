/*
leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo
pode começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24
horas.
*/

import java.util.Scanner;

public class Exercicio6 {

    public static String[] getHoraInicial(Scanner scanner) throws Exception{
        System.out.println("Digite a hora inicial: ");
        try{
            String fullDate = scanner.next();
            String[] date = fullDate.split(":");
            if(date.length != 2){
                throw new Exception("Formato de hora inválido. Use o formato hora:minuto");
            }

            return date;

        }catch(Exception e){
            throw e;

        }


    }
}
