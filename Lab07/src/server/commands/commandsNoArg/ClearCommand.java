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

        if(serverConnection.getDB().ClearCollection(serverConnection.getLogin(), serverConnection.getPassword())) {
            serverConnection.getServerCollection().updateCollection(serverConnection.getDB());
            out.write("Все ваши элементы удалены\n");
            out.flush();
        } else {
            out.write("В коллекции нет ваших элементов\n");
            out.flush();
        }
    }
}
