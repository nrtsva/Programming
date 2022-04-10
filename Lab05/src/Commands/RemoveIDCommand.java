package Commands;

import DragonParameters.Dragon;

public class RemoveIDCommand extends Command {
    public RemoveIDCommand() {
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    public void go() {
        int index = -1;
        for (Dragon d : CommandList.getDragons()) {
            if (d.getID() == CommandList.getInputID()) {
                index = CommandList.getDragons().indexOf(d);
            }
        }
        if (index > -1)
            CommandList.getDragons().remove(index);
        else System.err.println("Дракона с таким id нет");
    }
}
