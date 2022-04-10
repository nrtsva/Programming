package Commands;

import java.util.Collections;

public class ShuffleCommand extends Command {
    public ShuffleCommand() {
        super("shuffle", "перемешать элементы коллекции в случайном порядке");
    }
    @Override
    public void go() {
        Collections.shuffle(CommandList.getDragons());
    }
}
