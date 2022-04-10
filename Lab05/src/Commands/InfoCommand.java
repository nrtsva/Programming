package Commands;

public class InfoCommand extends Command {
    public InfoCommand() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void go() {
        System.out.println("Информация о коллекции:");
        System.out.println("  * тип: ArrayList<Dragon>");
        System.out.println("  * дата инициализации: ");
        System.out.println("  * количество элементов: " + CommandList.getDragons().size());
    }
}
