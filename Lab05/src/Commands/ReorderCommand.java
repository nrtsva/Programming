package Commands;

import java.util.Collections;

public class ReorderCommand extends Command {
    public ReorderCommand() {
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему");
    }
    @Override
    public void go() {
        Collections.reverse(CommandList.getDragons());
    }
}
