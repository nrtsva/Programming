package Commands;

import DragonParameters.Color;
import DragonParameters.DragonCharacter;
import DragonParameters.DragonType;

import java.util.Scanner;

public class ConsoleReader {
    public static String readName() {
        Scanner sc = new Scanner(System.in);
        String name;

        do {
            System.out.print("Name = ");
            name = sc.nextLine();
            if (name.equals(""))
                System.err.println("Имя не должно быть пустым");
        } while (name.equals(""));

        return name;
    }

    public static int readX() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int x = 0;

        do {
            System.out.print("X = ");
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                flag = true;
            } else {
                sc.next();
                System.err.println("X это целое число");
            }
        } while (!flag);
        return x;
    }

    public static float readY() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        float y = 0;

        do {
            System.out.print("Y = ");
            if (sc.hasNextFloat()) {
                y = sc.nextFloat();
                if (y > 508)
                    System.err.println("Y не может быть больше 508");
                else flag = true;
            } else {
                sc.next();
                System.err.println("Y это число типа float");
            }
        } while (!flag);
        return y;
    }

    public static Integer readAge() {
        Scanner sc = new Scanner(System.in);
        String age;
        Integer a = 0;
        boolean flag = false;

        do {
            System.out.print("Age = ");
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a > 0)
                    flag = true;
                else System.err.println("Возраст дракона должен быть больше 0");
            } else {
                age = sc.nextLine();
                if (age.equals("")) {
                    a = null;
                    flag = true;
                } else System.err.println("Возраст это целое число");
            }
        } while (!flag);
        return a;
    }

    public static Color readColor() {
        Scanner sc = new Scanner(System.in);
        String color;
        boolean flag = false;

        do {
            System.out.print("Color = ");
            color = sc.nextLine();
            if (color.equals("GREEN") || color.equals("RED") || color.equals("BLUE") || color.equals("WHITE") || color.equals("BROWN"))
                flag = true;
            else System.err.println("Выберите существующий цвет");
        } while (!flag);

        return Color.valueOf(color);
    }

    public static DragonType readType() {
        Scanner sc = new Scanner(System.in);
        String type;
        boolean flag = false;

        do {
            System.out.print("Type = ");
            type = sc.nextLine();
            if (type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("AIR"))
                flag = true;
            else System.err.println("Выберите существующий тип");
        } while (!flag);

        return DragonType.valueOf(type);
    }

    public static DragonCharacter readCharacter() {
        Scanner sc = new Scanner(System.in);
        String character;
        boolean flag = false;

        do {
            System.out.print("Character = ");
            character = sc.nextLine();
            if (character.equals("CUNNING") || character.equals("WISE") || character.equals("EVIL") || character.equals("FICKLE"))
                flag = true;
            else System.err.println("Выберите существующий характер");
        } while (!flag);

        return DragonCharacter.valueOf(character);
    }

    public static int readSize() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int s = 0;

        do {
            System.out.print("Size = ");
            if (sc.hasNextInt()) {
                s = sc.nextInt();
                flag = true;
            } else {
                sc.next();
                System.err.println("Размер это целое число");
            }
        } while (!flag);
        return s;
    }

    public static long readEyesCount() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        long e = 0;

        do {
            System.out.print("Eyes count = ");
            if (sc.hasNextLong()) {
                e = sc.nextLong();
                flag = true;
            } else {
                sc.next();
                System.err.println("Количество глаз это число типа long");
            }
        } while (!flag);
        return e;
    }

    public static Long readToothCount() {
        Scanner sc = new Scanner(System.in);
        String tcount;
        Long t = Long.valueOf(0);
        boolean flag = false;

        do {
            System.out.print("Tooth count = ");
            if (sc.hasNextLong()) {
                t = sc.nextLong();
                flag = true;
            } else {
                tcount = sc.nextLine();
                if (tcount == "") {
                    t = null;
                    flag = true;
                } else System.err.println("Возраст это число типа long");
            }

        } while (!flag);
        return t;
    }
}
