package DaGame;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE_X = 3;
    static int SIZE_Y = 3;
    static int DOTS_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void go() {
        printMap();

        if (checkWinLines(DOT_X)){
                System.out.println("Поздравляю с победой");
                return;
        }

        if (isFull()){
                System.out.println("Ничья.");
                return;
        }
        System.out.println("Ход компьютера");
        compTurn();
        printMap();
        if (checkWinLines(DOT_O)){
                System.out.println("Победил компьютер");
                return;
        }

        if (isFull()){
                System.out.println("Ничья.");
                return;
        }
    }

    static void initMap() {
        map = new char[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void humanTurn(int x, int y){
        if (checkWinLines(DOT_X ) || checkWinLines(DOT_O) || isFull()){
            return;
        }
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }
    //      Для повышения уровня AI на больших полях, применил массивы в которые записываются координаты победы AI и игрока.
//     Затем алгоритм сравнивает совпадающие координаты и присваевает их следующему ходу. Если совпадений не будет, то присваиваются
//    координаты победной точки, если координат победной точки не будет, то принимает координаты точки блокировки, и только в последнюю
//    очередь выбирает рандомно.
    static void compTurn() {
        int k = 0;
        int x = -1;
        int y = -1;
        int[] xX = new int[SIZE_X];
        for (int i = 0; i < SIZE_X; i++) {
            xX[i] = SIZE_X;
        }
        int[] yX = new int[SIZE_Y];
        for (int i = 0; i < SIZE_Y; i++) {
            yX[i] = SIZE_Y;
        }
        int[] xO = new int[SIZE_X];
        for (int i = 0; i < SIZE_X; i++) {
            xO[i] = SIZE_X;
        }
        int[] yO = new int[SIZE_Y];
        for (int i = 0; i < SIZE_Y; i++) {
            yO[i] = SIZE_Y;
        }

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
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

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
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

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (yO[i] != SIZE_Y && xO[j] != SIZE_X && yX[i] != SIZE_Y && xX[j] != SIZE_X && yO[i] == yX[j] && xO[i] == xX[j]) {
                    y = i;
                    x = j;
                }
            }
        }

        if(x == -1 || y == -1){
            x = xO[0];
            y = yO[0];
        }
        if(x == SIZE_X || y == SIZE_Y){
            x = xX[0];
            y = yX[0];
        }


        if (x == SIZE_X || y == SIZE_Y) {
            do {
                x = random.nextInt(SIZE_X);
                y = random.nextInt(SIZE_Y);
            }
            while (!isCellValid(y, x));
        }
        map[y][x] = DOT_O;
    }


    static boolean isCellValid(int y, int x){
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y){
            return false;
        } return map [y][x] == DOT_EMPTY;
    }

    static void printMap(){
        System.out.print("  ");
        for (int i = 1; i <= SIZE_Y; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean isFull(){
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        } return true;
    }


    //    Доработал checkLine и checkWinLines, опытным путём было установлено, что алгоритм который Вы показывали в начале
//    вебинара №5, не проверяла и не засчитывала победу справа на лево и справа на лево вниз.
//    При игре на поле 5х5 это было очень бросается в глаза.
    static boolean checkLine(int cy, int cx, int vy, int vx, char checkSymbol) {
        if (cx + vx * (DOTS_TO_WIN - 1) > SIZE_X - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE_Y - 1 ||
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
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
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
