package server.xmlFiles;

import server.data.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class xmlReader extends xmlData {
    public static ArrayList<Dragon> go() {
        ArrayList<Dragon> result = new ArrayList<Dragon>();
        Scanner sc = new Scanner(read());
        String[] type = {"id", "name", "coordinates", "creationDate", "age", "color", "type", "character", "head"};
        String[] fill = new String[9];
        int count = 0;

        while (sc.hasNext()) {
            String input = sc.nextLine();

            for (int i = 0; i < 9; i++) {
                try {
                    fill[i] = input.contains(type[i]) ? subString(input, type[i]) : fill[i];
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                    System.out.println("Некорректный формат данных в файле! Элемент №" + ++count + " не был добавлен в коллекцию");
                    //System.out.println("Ошибка в формате записи поля " + type[i]);
                }
            }

            if (input.contains("</dragon>")) {
                Integer age;
                try {
                    age = Integer.parseInt(fill[4]);
                }  catch (NumberFormatException e) {
                    age = null;
                }

                try {
                    Dragon tmp = new Dragon(Integer.parseInt(fill[0]),
                            fill[1],
                            parseCoordinates(fill[2]),
                            LocalDateTime.parse(fill[3]),
                            age,
                            Color.valueOf(fill[5]),
                            DragonType.valueOf(fill[6]),
                            DragonCharacter.valueOf(fill[7]),
                            parseDragonHead(fill[8]));
                    ++count;
                    result.add(tmp);
                } catch (java.lang.IllegalArgumentException e) {
                    System.out.println("Некорректный формат данных в файле! Элемент №" + ++count + " не был добавлен в коллекцию");
                }
            }
        }
        return result;
    }


    static String subString(String s, String input) {
        int inputIndex = s.indexOf(input) + input.length() + 1;
        StringBuilder result = new StringBuilder();
        for (int i = inputIndex; ; i++) {
            if (s.charAt(i) == '<')
                break;
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    static Coordinates parseCoordinates( String s ) {
        s = s.substring(1, s.length() - 1);
        String[] ss = s.replaceAll(" ", "").split(";");
        return new Coordinates(Integer.parseInt(ss[0]), Float.parseFloat(ss[1]));
    }

    static DragonHead parseDragonHead( String s ) {
        s = s.substring(1, s.length() - 1);
        String[] ss = s.replaceAll(" ", "").split(";");
        try {
            return new DragonHead(Integer.parseInt(ss[0]), Long.parseLong(ss[1]), Long.parseLong(ss[2]));
        }  catch (NumberFormatException e) {
            return new DragonHead(Integer.parseInt(ss[0]), Long.parseLong(ss[1]), null);
        }
    }
}