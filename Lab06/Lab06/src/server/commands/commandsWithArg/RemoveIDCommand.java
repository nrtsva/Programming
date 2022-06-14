package server.commands.commandsWithArg;

import server.commands.Command;
import server.data.Dragon;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a RemoveIDCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class RemoveIDCommand extends Command {
    int ID;

    /**
     * Constructor for making RemoveIDCommand
     */
    public RemoveIDCommand() {
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    /** Method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));
        int index = -1;

        ID = serverConnection.getInputID();

        for (Dragon d : serverConnection.getServerCollection().getDragons()) {
            if (d.getID() == ID) {
                index = serverConnection.getServerCollection().getDragons().indexOf(d);
            }
        }
        if (index > -1)
            serverConnection.getServerCollection().getDragons().remove(index);
        else {
            out.write("Дракона с таким id нет\n");
            out.flush();
        }

        out.write("Элемент с id = " + ID + " удален\n");
        out.flush();
    }
}
