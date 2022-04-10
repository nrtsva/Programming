package Commands;

import DragonParameters.Coordinates;
import DragonParameters.Dragon;
import DragonParameters.DragonHead;

public class AddCommand extends Command {
    public AddCommand() {
        super("add", "добавить новый элемент в коллекцию");
    }

    @Override
    public void go() {
        Dragon tmp = new Dragon();
        // read
        System.out.println("Введите имя дракона: ");
        tmp.setName(ConsoleReader.readName());

        System.out.println("Введите координаты дракона: ");
        tmp.setCoordinates(new Coordinates(ConsoleReader.readX(), ConsoleReader.readY()));

        System.out.println("Введите возраст дракона:");
        tmp.setAge(ConsoleReader.readAge());

        System.out.println("Введите цвет дракона {GREEN, RED, BLUE, WHITE, BROWN}:");
        tmp.setColor(ConsoleReader.readColor());

        System.out.println("Введите тип дракона {WATER, UNDERGROUND, AIR}:");
        tmp.setType(ConsoleReader.readType());

        System.out.println("Введите характер дракона {CUNNING, WISE, EVIL, FICKLE}:");
        tmp.setCharacter(ConsoleReader.readCharacter());

        System.out.println("Введите параметры головы дракона: ");
        tmp.setHead(new DragonHead(ConsoleReader.readSize(), ConsoleReader.readEyesCount(), ConsoleReader.readToothCount()));

        //System.out.println(tmp.toString());
        CommandList.getDragons().add(tmp);
    }

}
