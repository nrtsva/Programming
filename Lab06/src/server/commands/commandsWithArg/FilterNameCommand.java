package server.commands.commandsWithArg;

import server.commands.Command;
import server.data.Dragon;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a FilterNameCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class FilterNameCommand extends Command {
    /**
     * Constructor for making FilterNameCommand
     */
    public FilterNameCommand() {
        super("filter_contains_name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    /** Method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        for (Dragon d : ServerConnection.getServerCollection().getDragons()) {
            if (d.getName().contains(ServerConnection.getInputName())) {
                out.write(d.toString() + "\n");
                out.flush();
            }
        }
    }
}
