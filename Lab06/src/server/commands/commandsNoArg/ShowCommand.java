package server.commands.commandsNoArg;

import server.commands.Command;
import server.data.Dragon;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a ShowCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ShowCommand extends Command implements CommandNoArg {

    /**
     * Constructor for making ShowCommand
     */
    public ShowCommand() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    /** Abstract method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        for (Dragon d : serverConnection.getServerCollection().getDragons()) {
            out.write(d.toString() + "\n");
            out.flush();
        }
    }
}
