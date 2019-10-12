import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class FirstEducationProject {
   // Создание проекта Пункт ДЗ№1
        public static void main (String[] args){
            Scanner scanner = new Scanner(System.in);
        //Переменные Пункт ДЗ№2
        byte a;
        short b;
        int c;
        long d;
        float e;
        double f;
        char x;
        //String y;
        boolean z = true;
        boolean l = true;

        System.out.println("Пункт ДЗ№3");
        equation(a=8, b=16, c=64, d=32);

        System.out.println("Пункт ДЗ№4");
        System.out.println("Введите число №1");
        int g = scanner.nextInt();
        System.out.println("Введите число №2");
        int h = scanner.nextInt();
        dZ4(g, h, z);

        System.out.println("Пункт ДЗ№5");
        System.out.println("Введите число");
        int point5 = scanner.nextInt();
        dZ5(point5);

        System.out.println("Пункт ДЗ№6");
        System.out.println("Введите число");
        int point6 = scanner.nextInt();
        pointSix(point6, l);

        System.out.println("Пункт ДЗ№7");
        System.out.println("Введите имя");
        String y = String.valueOf(scanner.next());
            pointSeven(y);

        System.out.println("Пункт ДЗ№8");
        System.out.println("Введите год");
        int year = scanner.nextInt();
        pointEight(year);

          scanner.close();

            }



    static void equation (byte a, short b, int c, long d) {
         System.out.println(a * (b + (c / d)));
     }
     static void dZ4 (int g, int h, boolean z){
            if (( g + h )>=10 && ( g + h )<=20){
                z = z;
              } else {
                z = !z;
              }
            System.out.println(z);
        }
      static void dZ5 (int point5){
            if (point5 < 0){
                System.out.println("Отрицательное");
            } else {
                System.out.println("Положительное");
          }
      }

      static void pointSix(int point6, boolean l) {
              if (point6 >= 0){
              }
              else {
                  System.out.println(l);;
              }
        }

      static void pointSeven(String y){
          System.out.println("Привет, " + y + "!!!");
      }

      static void pointEight(int year){
            if ((year % 400) == 0 ) {
                System.out.println("Год високосный.");
            } else if ((year % 100) == 0 ) {
              System.out.println("Год не високосный.");
            } else if ((year % 4) == 0 ) {
                System.out.println("Год високосный.");
            } else {
                System.out.println("Год не високосный.");
            }

      }

      }

