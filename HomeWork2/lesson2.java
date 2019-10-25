package lesson2;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Arrays;
import java.util.Random;

public class lesson2 {
    public static void main (String[] args) {
////        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
////        С помощью цикла и условия заменить 0 на 1, 1 на 0;
//        int[] a = new int[10];
//        Random random = new Random();
//        System.out.print("[");
//        for (int i = 0; i < a.length; i++) {
//            a[i] = random.nextInt(2);
//            System.out.print(a[i] + ", ");
//            if (a[i] == 0) {
//                a[i]++;
//            } else {a[i]--;}
//
//        }
//        System.out.print("]");
//        System.out.println();
//        System.out.println(Arrays.toString(a));
//
////        2. Задать пустой целочисленный массив размером 8.
////        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//
//        int[] b = new int[8];
//        for (int i = 0; i < b.length; i++){
//          b[i] = i*3;
//        }
//        System.out.println(Arrays.toString(b));
//
////        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
////        пройти по нему циклом, и числа меньшие 6 умножить на 2;
//
//          int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(Arrays.toString(c));
//          for (int i = 0; i < c.length; i++){
//              if (c[i]<6){
//                  c[i] *= 2;
//              }
//          }
//        System.out.println(Arrays.toString(c));
//
////        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
////        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//
//        int[][] d = new int[5][5];
//        for (int i = 0; i < d.length; i++) {
//            for (int j = 0; j < d[i].length; j++){
//                if (i == j || (i + j) == 4) {
//                    d[i][j] = 1;
//                }
//            }
//        }
//
//        printMatrix(d);
//
//    }
//
//    private static void printMatrix(int[][] d) {
//        for (int i = 0; i < d.length; i++) {
//            for (int j = 0; j < d[i].length; j++) {
//                System.out.printf("\t%d", d[i][j]);}
//            System.out.println();
//        }
//    }
//
////    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//
//        int[] e = new int[15];
//        Random random = new Random();
//        for (int i = 0; i < e.length; i++) {
//            e[i] = random.nextInt(100);
//        }
//        System.out.println("Сгенерированный массив:");
//        System.out.println(Arrays.toString(e));
//        Arrays.sort(e);
//        System.out.println("Отсортированный массив:");
//        System.out.println(Arrays.toString(e));
//        System.out.println("Минимальное и максимальное числа:");
//        System.out.print(e[0] + ", ");
//        System.out.print(e[14]);
//    }

//         6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.

//        int[] f = {2,2,3,9,5,6,6,8,7,5,2};
//
//        checkBalance(f);
//}
//
//    private static boolean checkBalance(int[] f){
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < f.length; i++){
//            a = f[i] + a;
//            for (int j = i + 1; j < f.length; j++){
//                b = f[j] + b;
//            }
//            if (a == b){
//                return true;
//                }
//            b = 0;
//        }
//        return false;  НЕ УВЕРЕН, ЧТО ПРАВИЛЬНО. НЕ МОГУ ПОКА РАЗОБРАТЬСЯ С ПОНИМАНИЕМ RETURN И С ТЕМ КАК ОНО ОТОБРАЖАЕТСЯ

//        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Без использования интеренета даже в голову не приходит как это осуществить. По крайней мере с использованием
        // тех инструментов, которые были даны в уроке №2.
    }
}
