package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a InfoCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class InfoCommand extends Command implements CommandNoArg {

    /**
     * Constructor for making InfoCommand
     */
    public InfoCommand() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    /** Abstract method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));
        out.write("Информация о коллекции:\n" +
                "  * тип: ArrayList<Dragon>\n" +
                "  * дата инициализации: " + serverConnection.getServerCollection().getCreatingTime() + "\n" +
                "  * количество элементов: " + serverConnection.getServerCollection().getDragons().size() + "\n");
        out.flush();
    }
}
