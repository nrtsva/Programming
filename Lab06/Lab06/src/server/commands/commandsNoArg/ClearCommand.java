package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.*;
import java.net.Socket;

/**
 * Class for describing a ClearCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ClearCommand extends Command {
    /**
     * Constructor for making ClearCommand
     */
    public ClearCommand() {
        super("clear", "очистить коллекцию");
    }

    @Override
    /** Abstract method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        serverConnection.getServerCollection().getDragons().clear();

        out.write("Коллекция пуста\n");
        out.flush();
    }
}
