package Commands;

import DragonParameters.Dragon;

public class ShowCommand extends Command {
    public ShowCommand() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void go() {
        for (Dragon d : CommandList.getDragons()) {
            System.out.println(d.toString());
        }
    }
}
