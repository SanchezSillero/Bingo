import java.util.Arrays;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        //Pedir apuesta y prediccion
        System.out.println("Introduce apuesta");
        Scanner scanner = new Scanner(System.in);
        int apuesta = scanner.nextInt();
        System.out.println("Cuantos numeros crees q necesitaras para llegar a bingo");
        int prediccion = scanner.nextInt();

        //Crear cartón, formado por 10 números aleatorios (no repetidos entre el 1-99)
        int[] arrayCarton = new int[10];
        for (int i = 0; i < arrayCarton.length; i++) {
            arrayCarton[i] = (int) (Math.random() * 99) + 1;
            for (int j = 0; j < i; j++) {
                if (arrayCarton[i] == arrayCarton[(j)]) {
                    i--;
                }
            }
        }
        Arrays.sort(arrayCarton);
        System.out.println("Su cartón:");
        for (int numerosCarton : arrayCarton) {
            System.out.print(numerosCarton + " ");
        }

        //crear array de 100 n aleatorios no repetidos
        int[] arrayGenerados = new int[99];
        int numeroAciertos = 0;
        int[] arrayAciertos = new int[10];

        for (int i = 0; i < arrayGenerados.length; i++) {
            arrayGenerados[i] = (int) (Math.random() * 99) + 1;
            for (int j = 0; j < i; j++) {
                if (arrayGenerados[i] == arrayGenerados[j]) {
                    i--;
                }
            }
        }
        //comparar arrays para sacar el numero de aciertos
        for (int j = 0; j < arrayGenerados.length; j++) {
            for (int i = 0; i < arrayCarton.length; i++) {
                if (arrayGenerados[j] == arrayCarton[i]) {
                    numeroAciertos++;
                   //System.out.printf("Aciertos" + numeroAciertos);
                    if (numeroAciertos==5){
                        System.out.println();
                        System.out.println("¡LINEA!");
                        System.out.println("Han salido " + (j+1)+" números");
                    }
                    if (numeroAciertos==10){
                        System.out.println();
                        System.out.println("¡BINGO!");
                        System.out.println("Han salido " + (j+1)+" números");
                        if ((j+1)==prediccion){
                            System.out.println();
                            System.out.println("¡ENHORABUENA, su premio es: "+(apuesta*10));
                        }
                    }
                }
            }
        }

       /*System.out.println();
        for (int numerosGenerados : arrayGenerados) {
            System.out.print(numerosGenerados + " ");
        }*/
    }
}









