import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ZhirovVLesson6 {



//    Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//    Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//            * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
//            ** Написать метод, проверяющий, есть ли указанное слово в папке (Почитайте реализацию класса File)


    public  static void main (String[] args) throws IOException {

        FileInputStream fileInputStream = null;
        FileOutputStream outputStream = null;
        try {
             fileInputStream = new FileInputStream("D:\\txt\\1.txt");
             outputStream = new FileOutputStream("D:\\txt\\2.txt", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileInputStream.available() > 0) {

            outputStream.write(fileInputStream.read());
        }

        fileInputStream.close();
        outputStream.close();

        fileInputStream = new FileInputStream("D:\\txt\\2.txt");
        while (fileInputStream.available() > 0) {
            System.out.print(fileInputStream.read());
        }


        //При использовании сканнера   не удалось  сразу  читать по словам. Как  я почитал описание,
        //при применении разделителей такое должно получаться.

//        Scanner scannerFile = new Scanner(new FileInputStream("D:\\txt\\3.txt")).useDelimiter(" \t\n\\x0B\f\r");
//        String word = "The";
//        boolean presentWord = false;
//        while (scannerFile.hasNext()) {
//            String s = scannerFile.next();
//          presentWord =  word.equals(s);
 //       if (presentWord) {break;}
//        }
 //       System.out.println(presentWord);



        Scanner scannerFile = new Scanner(new FileInputStream("D:\\txt\\3.txt"));
        String word = "The";
        boolean presentWord = false;
        while (scannerFile.hasNext()) {
            presentWord = fineWordFile(scannerFile.nextLine(), word);
            if (presentWord) {break;}
        }
        scannerFile.close();
        System.out.println(presentWord);




    }///main


    public static boolean fineWordFile (String line , String word)  {
        boolean fineWord = false;
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
         String s = tokenizer.nextToken();
          fineWord =  (s).equals(word);
          if (fineWord) {break;}
        }
        return  fineWord;

    }//fineWordFile



}
