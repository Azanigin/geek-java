package J1T3;

import java.util.Scanner;

public class homeworkJ1T3 {
    public static void main(String[] args) {

        game();
    }

    public static void game() {
        int b;
        do{
        int x = (int)(Math.random() * 10); // Генерируем число
        Scanner number = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру, введите число от 0 до 9: ");
        for (int i=0; i<3; i++) { //Цикл на 3 попытки
            System.out.println("Попытка номер " + (i + 1));
            int a = number.nextInt(); // Считываем число
            if (a == x) { // Проверка на победу
                System.out.println("Поздравляю, вы победили!");
                break;
            } else if (x < a) System.out.println("Загаданное число меньше вашего");
            else System.out.println("Загаданное число больше вашего");
        }
        System.out.println("Если хотите повторить игру, то введите 1, если хотите закончить введите 0");
        b = number.nextInt(); // Проверка на продолжение игры
        }
        while (b==1);
        System.out.println("Game Over");
    }

}
