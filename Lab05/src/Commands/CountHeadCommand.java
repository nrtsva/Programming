package Commands;

import DragonParameters.Dragon;

public class CountHeadCommand extends Command {
    public CountHeadCommand() {
        super("count_by_head", "вывести количество элементов, значение поля head которых равно заданному(введите значения size, eyesCount, toothCount через пробел)");
    }

    @Override
    public void go() {
        int count = 0;
        for (Dragon d : CommandList.getDragons()) {
            if (d.getHead().equals(CommandList.getInputHead())) {
                count++;
            }
        }
        System.out.println("Count = " + count);
    }
}
