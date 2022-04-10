package Commands;

public class ClearCommand extends Command {
    public ClearCommand() {
        super("clear", "очистить коллекцию");
    }
    @Override
    public void go() {
        CommandList.getDragons().clear();
    }
}
