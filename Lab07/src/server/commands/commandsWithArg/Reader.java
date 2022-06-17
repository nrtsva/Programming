package server.commands.commandsWithArg;

import server.data.Color;
import server.data.DragonCharacter;
import server.data.DragonType;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class for communication with client
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class Reader {

    /**
     * Method for reading dragon's name
     *
     * @param clientSocket - client Socket
     * @return String name
     */
    public static String readName( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String name;

        out.write("Введите имя дракона: \n");
        out.flush();

        do {
            name = in.readLine();
            System.out.println(name);
            if (name.equals("")) {
                out.write("Имя не должно быть пустым! Введите имя: \n");
                out.flush();
            }
        } while (name.equals(""));

        return name;
    }

    /**
     * Method for reading dragon's coordinate
     *
     * @param clientSocket - client Socket
     * @return int X
     */
    public static int readX( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String s;
        int x = 0;

        out.write("Введите X: \n");
        out.flush();

        do {
            s = in.readLine();
            System.out.println(s);
            try {
                x = Integer.parseInt(s);
                flag = true;
            } catch (NumberFormatException e) {
                out.write("X - целое число! Введите X: \n");
                out.flush();
            }
        } while (!flag);
        return x;
    }

    /**
     * Method for reading dragon's coordinate
     *
     * @param clientSocket - client Socket
     * @return float Y
     */
    public static float readY( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String s;
        float y = 0;

        out.write("Введите Y: \n");
        out.flush();

        do {
            s = in.readLine();
            System.out.println(s);
            try {
                y = Float.parseFloat(s);
                if (y > 508) {
                    out.write("Y не может быть больше 508! Введите Y: \n");
                    out.flush();
                } else
                    flag = true;
            } catch (NumberFormatException e) {
                out.write("Y - число типа float! Введите Y: \n");
                out.flush();
            }
        } while (!flag);

        return y;
    }

    /**
     * Method for reading dragon's age
     *
     * @param clientSocket - client Socket
     * @return Integer age
     */
    public static Integer readAge( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String s;
        Integer a = 0;

        out.write("Введите возраст дракона: \n");
        out.flush();

        do {
            s = in.readLine();
            System.out.println(s);
            try {
                a = Integer.parseInt(s);
                if (a > 0)
                    flag = true;
                else {
                    out.write("Возраст дракона больше 0! Введите возраст дракона: \n");
                    out.flush();
                }
            } catch (NumberFormatException e) {
                if (s.equals("")) {
                    a = null;
                    flag = true;
                } else {
                    out.write("age - число типа Integer! Введите возраст дракона: \n");
                    out.flush();
                }
            }
        } while (!flag);
        return a;
    }

    /**
     * Method for reading dragon's color
     *
     * @param clientSocket - client Socket
     * @return Color color
     */
    public static Color readColor( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String color;

        out.write("Введите цвет дракона {GREEN, RED, BLUE, WHITE, BROWN}: \n");
        out.flush();

        do {
            color = in.readLine();
            System.out.println(color);
            if (color.equals("GREEN") || color.equals("RED") || color.equals("BLUE") || color.equals("WHITE") || color.equals("BROWN"))
                flag = true;
            else {
                out.write("Выберите существующий цвет! Введите цвет друкона: \n");
                out.flush();
            }
        } while (!flag);

        return Color.valueOf(color);
    }

    /**
     * Method for reading dragon's type
     *
     * @param clientSocket - client Socket
     * @return DragonType type
     */
    public static DragonType readType( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String type;

        out.write("Введите тип дракона {WATER, UNDERGROUND, AIR}: \n");
        out.flush();

        do {
            type = in.readLine();
            System.out.println(type);
            if (type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("AIR"))
                flag = true;
            else {
                out.write("Выберите существующий тип! Введите тип дракона: \n");
                out.flush();
            }
        } while (!flag);

        return DragonType.valueOf(type);
    }

    /**
     * Method for reading dragon's character
     *
     * @param clientSocket - client Socket
     * @return DragonCharacter character
     */
    public static DragonCharacter readCharacter( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String character;

        out.write("Введите характер дракона {CUNNING, WISE, EVIL, FICKLE}: \n");
        out.flush();

        do {
            character = in.readLine();
            System.out.println(character);
            if (character.equals("CUNNING") || character.equals("WISE") || character.equals("EVIL") || character.equals("FICKLE"))
                flag = true;
            else {
                out.write("Выберите существующий характер! Введите характер дракона: \n");
                out.flush();
            }
        } while (!flag);

        return DragonCharacter.valueOf(character);
    }

    /**
     * Method for reading dragon's head size
     *
     * @param clientSocket - client Socket
     * @return int size
     */
    public static int readSize( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String size;
        int s = 0;

        out.write("Введите Размер головы: \n");
        out.flush();

        do {
            size = in.readLine();
            System.out.println(size);
            try {
                s = Integer.parseInt(size);
                flag = true;
            } catch (NumberFormatException e) {
                out.write("Размер - целое число! Введите Размер головы: \n");
                out.flush();
            }
        } while (!flag);
        return s;
    }

    /**
     * Method for reading dragon's eyes count
     *
     * @param clientSocket - client Socket
     * @return long eyes count
     */
    public static long readEyesCount( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String ecount;
        long e = 0;
        out.write("Введите колличество глаз: \n");
        out.flush();

        do {
            ecount = in.readLine();
            System.out.println(ecount);
            try {
                e = Long.parseLong(ecount);
                flag = true;
            } catch (NumberFormatException ex) {
                out.write("Количество глаз - число типа long! Введите Колличество глаз: \n");
                out.flush();
            }
        } while (!flag);
        return e;
    }

    /**
     * Method for reading dragon's tooth count
     *
     * @param clientSocket - client Socket
     * @return Long tooth count
     */
    public static Long readToothCount( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String tcount;
        Long t = null;

        out.write("Введите колличество зубов: \n");
        out.flush();

        do {
            tcount = in.readLine();
            System.out.println(tcount);
            try {
                t = Long.parseLong(tcount);
                flag = true;
            } catch (NumberFormatException ex) {
                if (tcount.equals("")) {
                    t = null;
                    flag = true;
                } else {
                    out.write("Количество зубов - число типа long! Введите Колличество зубов: \n");
                    out.flush();
                }
            }
        } while (!flag);
        return t;
    }

    /**
     * Method for reading ID
     *
     * @param clientSocket - client Socket
     * @return int ID
     */
    public static int readID( Socket clientSocket ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        boolean flag = false;
        String s;
        int id = 0;

        out.write("Введите ID: \n");
        out.flush();

        do {
            s = in.readLine();
            System.out.println(s);
            try {
                id = Integer.parseInt(s);
                flag = true;
            } catch (NumberFormatException e) {
                out.write("ID - целое число! Введите ID: \n");
                out.flush();
            }
        } while (!flag);
        return id;
    }
}
