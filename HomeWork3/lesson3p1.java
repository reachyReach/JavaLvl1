package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3p1 {
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

//      1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
//      При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
//      После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        int n = 9;
        int attempts = 3;

        System.out.println("Давай поиграем в игру?;)");
        System.out.println("Угадай какое число Я задумал?");
        System.out.println("Подсказываю, оно в диапазоне от 1 до " + n + ".");
        System.out.println("Да, кстати у тебя только " + attempts + " попытки.");
        guessNumber(n, attempts);

    }

    static void guessNumber(int n, int attempts){
        while (true) {
            int z = random.nextInt(n);
            for (int i = 0; i < attempts; i++) {
                System.out.println("Введи число");
                int number = sc.nextInt();

                if (number == z) {
                    System.out.println("Поздравляю, ты угадал!!!");
                    break; }
                if (number > z) {
                    System.out.println("Я загадал число по меньше.");
                } else {
                    System.out.println("Я загадал число по больше."); }

                if (i == (attempts - 1)) {
                    System.out.println("Упс, не вышло");
                }

            }

            System.out.println("Хочешь сыграть ещё раз? 1 – да / 0 – нет");
            int repeat = sc.nextInt();
            if (repeat == 0) { break;
            }

        }
    }
}
