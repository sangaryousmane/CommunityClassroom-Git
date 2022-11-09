package files;

import java.io.*;

public class BinaryFile {

    public static void main(String[] args) throws IOException {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 19, 100};
        char[] letters = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z' };
//        writeInts(arr);
//        readFileInts();
        randomAccessFiles(letters);

    }

    static void writeInts(int[] arr) throws IOException {
        DataOutputStream outputStream =
                new DataOutputStream(new FileOutputStream("numbers.dat"));

        for (int num : arr) {
            outputStream.writeInt(num);
        }
        System.out.println("DONE");
        outputStream.close();
    }

    static void readFileInts() throws IOException {
        boolean isEndOfFile = false;
        DataInputStream inputStream =
                new DataInputStream(new FileInputStream("numbers.dat"));

        System.out.println("Reading numbers from the file....");

        while (!isEndOfFile) {
            try {
                int number = inputStream.readInt();
                System.out.print(number + " ");
            } catch (EOFException e) {
                isEndOfFile = true;
            }
        }
        System.out.println("DONE");
        inputStream.close();
    }

    static void randomAccessFiles(char[] letter) throws IOException {


        RandomAccessFile random=new RandomAccessFile("letter.dat", "rw");
        System.out.println("Sequentially writing the letters to the file.");
        for (char let: letter){
            random.writeChar(let);
        }
        System.out.println("DONE..");
        random.close();
    }
}
