package Session3.Task2;


import java.io.*;
import java.util.ArrayList;


class FileThread extends Thread {
    static ArrayList<String> str = new ArrayList<>();
    File file;

    public FileThread(File file) {
        this.file = file;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp = null;

            while ((temp = bufferedReader.readLine()) != null) {
                str.add(temp);
                System.out.println(temp);
            }
            System.out.println("File read successfully " + file.getName());
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public void writeFile(File file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(IOOperationUsingThread.file3, true));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String i : str) {
            try {
                bufferedWriter.write(i);
                bufferedWriter.newLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("File write successfully in " + file.getName());

        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class IOOperationUsingThread {
    static File file1 = new File("C:/Users/TJAVA06/KnovosTraining/Session Task/src/Session3/Task2/File1");
    static File file2 = new File("C:/Users/TJAVA06/KnovosTraining/Session Task/src/Session3/Task2/File2");
    static File file3 = new File("C:/Users/TJAVA06/KnovosTraining/Session Task/src/Session3/Task2/File3");

    public static void main(String[] args) {

        FileThread thread1 = new FileThread(file1);
        FileThread thread2 = new FileThread(file2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        FileThread.writeFile(file3);
    }
}
