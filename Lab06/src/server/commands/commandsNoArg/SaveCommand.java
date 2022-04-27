package server.commands.commandsNoArg;

import server.commands.Command;
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
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        xmlWriter.CreateFile();
        xmlWriter.go();

        out.write("Изменения сохранены\n");
        out.flush();
    }
}
