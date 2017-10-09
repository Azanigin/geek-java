import java.util.Random;
import java.util.Scanner;

public class Game {

    public static char [][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';
    public static Random random = new Random();

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        mapINIT();
        printMAP();
        for (int i=0; i<=SIZE+1; i++){
            humanTurn();
            printMAP();
            if (winCHECK(DOT_X)){
                System.out.println("Победил человек");
                break;
            }

            if (i==SIZE+1){
                System.out.println("НИЧЬЯ");
                break;
            }

            iiTurn();
            printMAP();
            if (winCHECK(DOT_O)) {
                System.out.println("Победил компьютер!");
                break;
            }
        }

    }

    public static void  iiTurn(){
        int x,y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        }
        while (!check(x,y));
        map[y][x] = DOT_O;
        System.out.println("Компьютер сделал ход!");
    }

    public static void  humanTurn(){
        int x,y;
        do {
            System.out.println("Ваш ход: ");
            System.out.println("Введите Х: ");
            x = scanner.nextInt() - 1;
            System.out.println("Введите Y: ");
            y = scanner.nextInt() - 1;
        }
        while (!check(x,y));
        map[y][x] = DOT_X;

    }

    public static boolean check (int x, int y) {
        if (x<0 || x>=SIZE || y<0 || y>=SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;

    }

    public static boolean winCHECK (char symb) {
        boolean z = false;
        for (int i=0; i<SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {
                if (map[i][j] == symb){ // нахождение первого символа
                    for (int k = 1;j+k < SIZE && map[i][j + k] == symb; k++) { // цикл для проверки последовательностельности подряд по горизонтали
                        if (k==DOTS_TO_WIN-1) z = true;
                    }
                    for (int k = 1; i+k < SIZE && map[i+k][j] == symb; k++) { // цикл для проверки последовательностельности подряд по вертикали
                        if (k==DOTS_TO_WIN-1) z = true;
                    }
                    for (int k = 1; j+k<SIZE && i+k < SIZE && map[i+k][j+k] == symb; k++) { // цикл для проверки последовательностельности подряд по диагонали
                        if (k==DOTS_TO_WIN-1) z = true;
                    }
                    for (int k = 1; i>=DOTS_TO_WIN-1 && j+k<SIZE && i < SIZE && map[i-k][j+k] == symb; k++) { // цикл для проверки последовательностельности подряд по обратной диагонали
                        if (k==DOTS_TO_WIN-1) z = true;
                    }
                }
            }
        } return z;
    }

    public static void mapINIT (){
        map = new char[SIZE][SIZE];
        for (int i=0; i<SIZE; i++){
            for (int j = 0; j <SIZE ; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    public static void  printMAP () {
        for (int i=0; i<=SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i =0; i< SIZE; i++){
            System.out.print(i+1 + " ");
            for (int j = 0; j <SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
