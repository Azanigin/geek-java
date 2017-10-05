package J1T3;

import java.util.Scanner;

public class homeworkJ1T3 {
    public static void main(String[] args) {

        game();
        game2();
    }

    public static void game() {
        int b;
        do{
        int x = (int)(Math.random() * 10); // Генерируем число
        Scanner number = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру №1, введите число от 0 до 9: ");
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

    public static void game2(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Добро пожаловать в игру №2, вам требуется угадать слово.");
        String key = new String();
        key = words[(int) (Math.random() * words.length)]; // Загадываем случайное слово из списка

        System.out.println("Загаданное слово: " + key); // Выводим себе слово для отладки

        Scanner reader = new Scanner(System.in); // Ввод данных пользователя
        String uin = new String();
        char [] temp = new char[key.length()+5] ;
        for (int i=0; i<key.length()+Math.random()*10;i++) temp[i] = '#'; // генерируем подсказку из случайного кол-ва символов

        for (int i=0; !key.equalsIgnoreCase(uin);i++ ) { // Цикл попыток с проверкой
            System.out.println("Попытка номер " + i);
            uin = reader.nextLine();
            for (int j=0; j < key.length() && j < uin.length();j++)
                if (uin.charAt(j) == key.charAt(j)) temp[j] = key.charAt(j);

            System.out.println(temp);
        }
        System.out.println("Поздравляю! вы выиграли АВТОМОБИЛЬ!");
    }
}
