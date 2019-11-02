package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson4 {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinLines(DOT_X)){
                System.out.println("Поздравляю с победой");
                break;
            }

            if (isFull()){
                System.out.println("Ничья.");
                break;
            }
            System.out.println("Ход компьютера");
            compTurn();
            printMap();
            if (checkWinLines(DOT_O)){
                System.out.println("Победил компьютер");
                break;
            }

            if (isFull()){
                System.out.println("Ничья.");
                break;
            }
        }
    }

    static void initMap() {
                map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void humanTurn(){
        int x, y;
        do { System.out.println("Введи координаты X, Y.");
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;}
        while (!isCellValid(y, x));
        map [y][x] = DOT_X;
    }
//      Для повышения уровня AI на больших полях, применил массивы в которые записываются координаты победы AI и игрока.
//     Затем алгоритм сравнивает совпадающие координаты и присваевает их следующему ходу. Если совпадений не будет, то присваиваются
//    координаты победной точки, если координат победной точки не будет, то принимает координаты точки блокировки, и только в последнюю
//    очередь выбирает рандомно.
    static void compTurn() {
        int k = 0;
        int x = -1;
        int y = -1;
        int[] xX = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            xX[i] = SIZE;
        }
        int[] yX = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            yX[i] = SIZE;
        }
        int[] xO = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            xO[i] = SIZE;
        }
        int[] yO = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            yO[i] = SIZE;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i,j)) {
                    map[i][j] = DOT_O;
                if (checkWinLines(DOT_O)) {
                    yO[k] = i;
                    xO[k] = j;
                    k++;
                }
                map[i][j] = DOT_EMPTY;
                }
            }
        }
        k = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i,j)) {
                    map[i][j] = DOT_X;
                if (checkWinLines(DOT_X)) {
                    yX[k] = i;
                    xX[k] = j;
                    k++;
                }
                map[i][j] = DOT_EMPTY;
                }
            }
        }
        k = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (yO[i] != SIZE && xO[i] != SIZE && yX[i] != SIZE && xX[i] != SIZE && yO[i] == yX[j] && xO[i] == xX[j]) {
                y = i;
                x = j;
                }
            }
            }

        if(x == -1 || y == -1){
            x = xO[0];
            y = yO[0];
        }
        if(x == SIZE || y == SIZE){
            x = xX[0];
            y = yX[0];
        }


        if (x == SIZE || y == SIZE) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                }
                while (!isCellValid(y, x));
            }
            map[y][x] = DOT_O;
    }


    static boolean isCellValid(int y, int x){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            return false;
        } return map [y][x] == DOT_EMPTY;
    }

    static void printMap(){
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        } return true;
    }
//      Метод работает, однако как выяснилось в нём есть изъян. Если будут стоять два(три) чекСимвола, пробел или символ противника,
//    а затем еще два(один) чекСимвол. Алгоритм засчитает победу.
//    static boolean checkWin(char n){
//        int score = 0;
//        for ( int i = 0; i < SIZE; i++){
//            for (int j = 0; j < SIZE; j++){
//                   if (map[i][j] == n){
//                   score++;
//                }
//            }
//            if (score >= DOTS_TO_WIN){
//               return true;
//               }
//            score = 0;
//        }
//        score = 0;
//        for (int i = 0; i < SIZE; i++){
//            for (int j = 0; j < SIZE; j++){
//                if (map[j][i] == n){
//                    score++;
//                }
//
//            }
//            if (score >= DOTS_TO_WIN){return true;
//            }
//            score = 0;
//        }
//        score = 0;
//
//        for (int i = SIZE -1; i > -SIZE; i--){
//            for (int j = 0; j < SIZE; j++){
//                if(i + DOTS_TO_WIN > SIZE || i + j < 0 || i + j >= SIZE){continue;}
//                if (map[i+j][j] == n){
//                    score++;
//                }
//
//            }
//            if (score >= DOTS_TO_WIN){return true;
//            }
//            score = 0;
//        }
//        score = 0;
//
//        for (int i = SIZE -1; i > -SIZE; i--){
//            for (int j = SIZE-1; j >= 0; j--){
//                if(i + DOTS_TO_WIN > SIZE || i + j < 0 || i + j >= SIZE){continue;}
//                if (map[i+j][SIZE - 1 - j] == n){
//                    score++;
//                }
//
//            }
//            if (score >= DOTS_TO_WIN){return true;
//            }
//            score = 0;
//        }
//        score = 0;
//
//        return false;
//    }

//    Доработал checkLine и checkWinLines, опытным путём было установлено, что алгоритм который Вы показывали в начале
//    вебинара №5, не проверяла и не засчитывала победу справа на лево и справа на лево вниз.
//    При игре на поле 5х5 это было очень бросается в глаза.
static boolean checkLine(int cy, int cx, int vy, int vx, char checkSymbol) {
    if (cx + vx * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE - 1 ||
            cy + vy * DOTS_TO_WIN - 1 < 0 || cx + vx * (DOTS_TO_WIN - 1) < 0 ) {
        return false;
    }

    for (int i = 0; i < DOTS_TO_WIN; i++) {
        if (map[cy + i * vy][cx + i * vx] != checkSymbol) {
            return false;
        }
    }
    return true;
}

    static boolean checkWinLines(char checkSymbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, checkSymbol) || checkLine(i, j, 0, -1, checkSymbol) ||
                        checkLine(i, j, 1, 0, checkSymbol) || checkLine(i, j, 1, 1, checkSymbol) ||
                        checkLine(i, j, -1, 1, checkSymbol)|| checkLine(i, j, 1, -1, checkSymbol)) {
                    return true;
                }
            }
        }
        return false;
    }

}