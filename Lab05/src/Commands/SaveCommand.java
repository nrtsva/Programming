package Commands;

import xmlFiles.xmlWriter;

public class SaveCommand extends Command {
    public SaveCommand() {
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    public void go() {
        xmlWriter.CreateFile();
        xmlWriter.go();
        System.out.println("Данные сохранены.");
    }
}
