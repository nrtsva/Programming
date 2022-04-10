package Commands;

import java.util.Map;

public class HelpCommand extends Command {
    public HelpCommand(){
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void go() {
        for (Map.Entry<String, Command> entry: CommandList.getMap().entrySet()) {
            System.out.println(entry.getValue().getName() + ": " + entry.getValue().getDescription());
        }
    }
}
