

import java.util.Arrays;

public class ZhirovVLesson2 {


   public static void main (String[] args) {

       //1 Задать целочисленный массив, состоящий из элементов 0 и 1.
       // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0  };

    firstArray = firstTaskIF(firstArray);
    firstArray = firstTaskTernar(firstArray);
    System.out.println("Task   1  :  " + Arrays.toString(firstArray));

    //Задание 2
    int[] secondArray = new int[8];
    secondArray = secondTask(secondArray);
    System.out.println("Task2  =   " + Arrays.toString(secondArray));

    //Задание 3
   int[] thirdArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
   thirdArray = thirdTask(thirdArray);
   System.out.println("Task3  =  " + Arrays.toString(thirdArray));

   //Задание 4

    double[] forthArray = { 1.5, 2.5, 9.8, -3.2, -0.3, 10.2 };
    System.out.println("min =  "  + minValueArray(forthArray));
    System.out.println("max =  " + maxValueArray(forthArray));

    //Задание 5
    int column = 5;
    int[][] fifthArray = fifthTask(5);
    System.out.println( "Task 5  =   " + Arrays.deepToString(fifthArray));
    fifthTaskOutput(fifthArray);

    //Задание 6
   // checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
       // checkBalance ([10, || 1, 2, 3, 4]) → true.
    int[] checkBalanceFirst = {1, 1, 1,  2, 1 };
    int[] checkBalanceSecond = { 2, 1, 1, 2, 1 };
    int[] checkBalanceThird = { 10, 1, 2, 3, 4 };

    System.out.println("checkBalanceFirst  = " + sixthTask(checkBalanceFirst) + " checkBalanceSecond =  " +
               sixthTask(checkBalanceSecond) + "   checkBalanceThird =  " +  sixthTask(checkBalanceThird));

    //Задание 7
     int[] seventhArray = { 1, 2, 3, 4, 5, 6, 7};
     seventhArray = seventhTask(seventhArray, -2);
       System.out.println("Task 7  =  "  + Arrays.toString(seventhArray));

   } //main


    //1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    //  с использование   if - else
    static int[] firstTaskIF (int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if ( arr[i] == 1) {
               arr[i] = 0;
           }
           else {
                arr [i] = 1;
           }
       }
    return arr;
    }//FirstTaskIf
    // с использованием тернарного оператора
    static int[] firstTaskTernar (int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           arr[i] = (arr[i] == 1) ?  0:  1;
       }
    return  arr;
    }//firstTaskTernar

    //2 Задать пустой целочисленный массив размером 8.
    // Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

    static int[] secondTask (int[] arr) {
       for (int i = 0; i < arr.length; i++ ) {
           arr[i] = 1 + i * 3;
       }
    return arr;
    }//secondTask

    //3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    // написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    static int[] thirdTask (int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if (arr [i] < 6)  {
               arr[i] *= 2;
           }
       }
    return arr;
    }//thirdTask

    //4 Задать одномерный массив.
    // Написать методы поиска в нём минимального и максимального элемента;
    static double  minValueArray (double[] arr) {
       double min = arr [0];
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] < min) {
               min = arr[i];
           }
       }
    return min;
    } //minValueArray

    static double maxValueArray (double[] arr)  {
       double max = arr[0];
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] > max ) {
               max = arr[i];
           }
       }
    return max;
    }//maxValueArray

   // 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
   // заполнить его диагональные элементы единицами, используя цикл(ы);

    static int[][] fifthTask (int colunm) {
       int[][] arr = new int[colunm][colunm];
       for (int i= 0; i < colunm; i++) {
           for (int j = 0; j < colunm; j++) {
               arr[i][j] =  (i == j) ? 1 : 0;
           }
       }
    return arr;
    }//fifthTask

    static void fifthTaskOutput (int[][] arr) {
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr[i].length; j++) {
               System.out.printf("%3d", arr[i][j]);
           }
        System.out.println();
       }
    }//fifthTaskOutput

    //6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 1, 2, 3, 4]) → true.
    // Абстрактная граница показана символами ||, эти символы в массив не входят.

    static boolean sixthTask (int[] arr) {
       int left = 0;
       int right = 0;
       for (int i = 0;  i < arr.length; i++) {
            left = 0;
            right = 0;
           for (int j = 0;  (j <= i) && (j < (arr.length - 1)) ; j++ ) {
               left  = left + arr[j];
           }
           for (int k = arr.length-1; k > i; k--) {
               right = right +arr[k];
               if (right > left) break;
           }
       if (right == left) break;
       }
    return right == left;
    }//sixTask

    //7 *** Написать метод, которому на вход подаётся одномерный массив и число n
    // (может быть положительным, или отрицательным),
    // при этом метод должен циклически сместить все элементы массива на n позиций.

    static int[] seventhTask (int[] arr, int n) {
       n = n % arr.length;

       for (int i = arr.length, j = n, temp2 = arr[0], temp = 0; i > 0; i--, j = j + n) {

           if (j < 0) j = arr.length + j;
           if (j >= arr.length) j = j -arr.length ;
           temp = arr[j];
           arr[j] = temp2;
           temp2 = temp;

        }
    return arr;
    }//seventhTask

}//Lesson2
