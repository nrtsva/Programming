package Commands;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public void go() {
        CommandList.setGoFlag(false);
    }
}
