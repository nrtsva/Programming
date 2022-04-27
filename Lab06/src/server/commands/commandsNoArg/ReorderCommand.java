package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Collections;

/**
 * Class for describing a ReorderCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ReorderCommand extends Command {
    /**
     * Constructor for making ReorderCommand
     */
    public ReorderCommand() {
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему");
    }

    @Override
    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        Collections.reverse(ServerConnection.getServerCollection().getDragons());

        out.write("Коллекция отсортирована\n");
        out.flush();
    }
}
