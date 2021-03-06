package server.commands.commandsNoArg;

import server.Comparators.DragonIDComparator;
import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Collections;

/**
 * Class for describing a PrintAscendingCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class PrintAscendingCommand extends Command {
    /**
     * Constructor for making PrintAscendingCommand
     */
    public PrintAscendingCommand() {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
    }

    @Override
    /** Abstract method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        Collections.sort(serverConnection.getServerCollection().getDragons(), new DragonIDComparator());

        out.write("Коллекция отсортирована\n");
        out.flush();
    }
}
