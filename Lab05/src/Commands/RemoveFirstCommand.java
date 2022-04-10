package Commands;

public class RemoveFirstCommand extends Command {
    public RemoveFirstCommand() {
        super("remove_first", "удалить первый элемент из коллекции");
    }

    @Override
    public void go() {
        if (!CommandList.getDragons().isEmpty())
            CommandList.getDragons().remove(0);
    }
}
