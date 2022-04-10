package xmlFiles;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class xmlData {

    protected static String fileName = "example.xml";

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName( String fileName ) {
        xmlData.fileName = fileName;
    }

    public static void CreateFile() {
        try {
            File f = new File(fileName);
            if (f.createNewFile())
                System.out.println("Инициализация файла...");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void write(String text) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        StringBuilder line = new StringBuilder();
        try {
            Scanner sc = new Scanner(Paths.get(fileName));
            do {
                line.append(sc.nextLine()).append("\n");
            } while (sc.hasNext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.toString();
    }
}