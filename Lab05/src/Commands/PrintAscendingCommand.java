package Commands;

import Comparators.DragonIDComparator;

import java.util.Collections;

public class PrintAscendingCommand extends Command {
    public PrintAscendingCommand() {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
    }
    @Override
    public void go() {
        Collections.sort(CommandList.getDragons(), new DragonIDComparator());
    }
}
