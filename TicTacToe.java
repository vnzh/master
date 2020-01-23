import java.util.Random;
import java.util.Scanner;



public class TicTacToe {

    private  static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner((System.in));
    private static final Random RANDOM = new Random();
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char [][] field;
//    private static char[][] field = {      {DOT_AI, DOT_EMPTY, DOT_HUMAN},
//        {DOT_HUMAN, DOT_HUMAN, DOT_AI},
//        {DOT_AI,DOT_AI, DOT_HUMAN},         };

    private static int lineFishki = 4;  //длина фишек для победы


    public static void main (String[] args) {
       initField();
//        fieldSizeY = 3;
//        fieldSizeX = 3;
        printField();

        while (true) {
            humanTurn();
            printField();

            if ( (checkWin(DOT_HUMAN, field))) {
                System.out.println("You win!");
                break;
            }
            //  Если не провести проверку на ничью, то   ход  компьютера  в цикле while  юудет бесконечным,
            //  если  все поля заняты
            if (isDraw()) {
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI, field)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw");
                break;
            }
        }//while
    }//main

//    private static void terms() {
//        do {
//            System.out.println("Input gamefield size  (from 3  to 5");
//            fieldSizeX = SCANNER.nextInt();
//            fieldSizeY = SCANNER.nextInt();
//        } while (checkFieldSize(fieldSizeX) && checkFieldSize(fieldSizeY));
//
//
//    }//terms
//
//    private static boolean checkFieldSize(int i) {
//        return i >= 3 && i <= 5;
//    }

    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] =DOT_EMPTY;
            }
        }
    }//initField

    private static void printField() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }//printField

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Input coordinates >>  ");
            x = SCANNER.nextInt();
            y = SCANNER.nextInt();
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }//humanTurn

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x <fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //перегрузка метода  Перегружен для использования  в проверке на победу
    private static boolean isCellValid(int x, int y, char[][] arr) {
        return x >= 0 && x <arr[0].length && y >= 0 && y < arr.length;
    }

    private static boolean isCellEmpty (int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        char[][] arr = field;


    // проверка на победу компьютера   в один ход
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(j,i)) {
                    arr[i][j] = DOT_AI;
                    if (checkWin(DOT_AI, arr)) {
                        field[i][j] = DOT_AI;
                        return;
                    }
                    else arr[i][j] = DOT_EMPTY;
                }
            }
        }

        // проверка на победу человеа в один ход
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {

                if (isCellEmpty(j,i)) {
                    arr[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN, arr)) {
                        field[i][j] = DOT_AI;
                        return;
                    }
                    else arr[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }//aiTurn


    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }//isDra
    			//добавлен   в сигнатуру  масссив чаров, чтобы можно было   использовать метод в проверках искуственного интеллекта
    private static boolean checkWin(char c, char[][] arr) {
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
//        return false;
         int count = 0;
        //проверка  строк
        for (int y = 0; y < arr.length; y++) {
            count = 0;
            for (int x = 0; x < arr[y].length - 1; x++) {
               if (arr[y][x] == c && arr[y][x] == arr[y][x+1]  ) {count++;}
               else count = 0;
               if (count == lineFishki-1) return true;
            }
        }
        //проверка столбцов
        for (int x = 0; x < arr[0].length; x++) {
            count = 0;
            for (int y = 0; y < arr.length-1; y++) {
                if (arr[y][x] == c && arr[y][x] == arr[y+1][x]  ) {count++;}
                else count = 0;
                if (count == lineFishki-1) return true;
            }

        }
        //диагонали  слева направо-вниз  Берем значение, и от него   идем по диагонали на растояние фишек, необходимое
        //для победы
        // XOOO
        // OXOO
        // OOXO
        // OOOX
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                count = 0;
                for (int i = 0; (i < lineFishki-1) && isCellValid(x + i + 1, y + i + 1, arr); i++) {
                    if (arr[y+i][x+i] == c && arr[y+i][x+i] == arr[y+i+1][x+i+1]) count++;
                    else count = 0;
                    if (count == lineFishki-1) return true;
                }

            }
        }
        // диагонали  справо-налево-вниз

        // OOOX
        // OOXO
        // OXOO
        // XOOO
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                count = 0;
                for (int i = 0; (i < lineFishki -1) && isCellValid(x + i +1, y - i -1, arr ); i++) {
                    if (arr[y-i][x+i] == c && arr[y -i] [x+i] == arr[y-i-1][x+i+1]) count++;
                    else count = 0;
                    if (count == lineFishki-1) return true;
                }

            }
        }

        return false;

    }//checWin

}//TicTacToe
