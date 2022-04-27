package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a RemoveFirstCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class RemoveFirstCommand extends Command {
    /**
     * Constructor for making RemoveFirstCommand
     */
    public RemoveFirstCommand() {
        super("remove_first", "удалить первый элемент из коллекции");
    }

    @Override
    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        if (!ServerConnection.getServerCollection().getDragons().isEmpty())
            ServerConnection.getServerCollection().getDragons().remove(0);

        out.write("Первый элемент удален\n");
        out.flush();
    }
}
