package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;
import server.xmlFiles.xmlWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a SaveCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class SaveCommand extends Command {
    /**
     * Constructor for making SaveCommand
     */
    public SaveCommand() {
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    /** Abstract method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        xmlWriter.CreateFile();
        xmlWriter.go(serverConnection);

        out.write("Изменения сохранены\n");
        out.flush();
    }
}
