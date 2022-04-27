package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Collections;

/**
 * Class for describing a ShuffleCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ShuffleCommand extends Command {
    /**
     * Constructor for making ShuffleCommand
     */
    public ShuffleCommand() {
        super("shuffle", "перемешать элементы коллекции в случайном порядке");
    }

    @Override
    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        Collections.shuffle(ServerConnection.getServerCollection().getDragons());

        out.write("Коллекция перемешана в случайном порядке\n");
        out.flush();
    }
}
