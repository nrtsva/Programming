package Commands;

import DragonParameters.Coordinates;
import DragonParameters.Dragon;
import DragonParameters.DragonHead;

public class UpdateIDCommand extends Command {
    public UpdateIDCommand() {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void go() {
        Dragon tmp = new Dragon();

        int index = -1;
        for (Dragon d : CommandList.getDragons()){
            if (d.getID() == CommandList.getInputID()){
                index = CommandList.getDragons().indexOf(d);
            }
        }
        if (index == -1) {
            System.err.println("Дракона с таким id нет");
            return;
        }

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
        CommandList.getDragons().set(index, tmp);
    }
}
