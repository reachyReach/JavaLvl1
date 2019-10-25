package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3p2 {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {

// 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
// "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
// "pear", "pepper", "pineapple", "pumpkin", "potato"};
//
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int i = random.nextInt(words.length);

        game(words[i]);
    }

    static void game(String s1){
        System.out.println("Guess the fruit I made");
        String fruit;
        do {
            fruit = sc.nextLine();
            int letterCount =Math.min(s1.length(), fruit.length());
            for (int i = 0; i < letterCount; i++) {
                if (s1.charAt(i) == fruit.charAt(i)){
                    System.out.print(s1.charAt(i));
                }
                else {
                    System.out.print("#");
                }
            }
            for (int i = letterCount; i < 15; i++) {
                if (s1.equals(fruit)){break;}
                System.out.print("#");
        }
            System.out.println();
        }
        while (!s1.equals(fruit));
        System.out.println("yahooo!!!");
    }
}
