package Commands;

import DragonParameters.Dragon;

public class FilterNameCommand extends Command {
    public FilterNameCommand() {
        super("filter_contains_name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    public void go() {
        for (Dragon d : CommandList.getDragons()) {
            if (d.getName().contains(CommandList.getInputName()))
                System.out.println(d.toString());
        }
    }
}
