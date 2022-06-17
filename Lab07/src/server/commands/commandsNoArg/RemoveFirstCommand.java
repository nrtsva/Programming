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
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        int id;
        if (!serverConnection.getServerCollection().getDragons().isEmpty()) {
            id = serverConnection.getServerCollection().getDragons().get(0).getID();

            if (serverConnection.getDB().checkCreator(id, serverConnection.getLogin(), serverConnection.getPassword())) {
                if (serverConnection.getDB().removeElementById(id, serverConnection.getLogin(), serverConnection.getPassword())) {
                    serverConnection.getServerCollection().updateCollection(serverConnection.getDB());
                    out.write("Первый элемент удален\n");
                    out.flush();
                } else {
                    out.write("Не удалось удалить дракона\n");
                    out.flush();
                }
            } else {
                out.write("Нельзя удалить чужого дракона!\n");
                out.flush();
            }
        }
    }
}
