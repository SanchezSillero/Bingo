import java.util.Arrays;
import java.util.Scanner;

public class Bingo2 {
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
        int posicionGenerados = 0;
        int repetido=0;

        do {
            do{
                repetido=0;
                arrayGenerados[posicionGenerados] = (int) (Math.random() * 99) + 1;
                for (int j = 0; j < posicionGenerados; j++) {
                    if (arrayGenerados[posicionGenerados] == arrayGenerados[j])
                        repetido=1;

                }

            }while(repetido==1);

            for (int i = 0; i < arrayCarton.length; i++) {
                if (arrayGenerados[posicionGenerados] == arrayCarton[i]) {
                    numeroAciertos++;
                    System.out.println();
                    System.out.printf("Aciertos" + numeroAciertos);
                    if (numeroAciertos == 5) {
                        System.out.println();
                        System.out.println("¡LINEA!");
                        System.out.println("Han salido " + (posicionGenerados + 1) + " números");
                    }
                    if (numeroAciertos == 10) {
                        System.out.println();
                        System.out.println("¡BINGO!");
                        System.out.println("Han salido " + (posicionGenerados + 1) + " números");
                        if ((posicionGenerados + 1) == prediccion) {
                            System.out.println();
                            System.out.println("¡ENHORABUENA, su premio es: " + (apuesta * 10));
                        }
                    }
                }

            }
            posicionGenerados++;


        } while (numeroAciertos < 10);
        System.out.println();
        for (int numerosGenerados : arrayGenerados) {
            System.out.print(numerosGenerados + " ");
        }
    }
}
