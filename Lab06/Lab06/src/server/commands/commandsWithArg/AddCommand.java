package server.commands.commandsWithArg;

import server.commands.Command;
import server.data.Coordinates;
import server.data.Dragon;
import server.data.DragonHead;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a AddCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class AddCommand extends Command implements CommandWithArg {
    Dragon tmp;

    /**
     * Constructor for making AddCommand
     */
    public AddCommand() {
        super("add", "добавить новый элемент в коллекцию");
    }

    /** Method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        tmp = new Dragon();
        getArguments(serverConnection.getClientSocket());
        serverConnection.getServerCollection().getDragons().add(tmp);

        out.write("Объект добавлен в коллекцию\n");
        out.flush();
    }

    @Override
    /** Method getArguments from interface
     *
     * @param clientSocket - Client socket
     */
    public void getArguments(Socket clientSocket) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write("start_read_arg\n");
        out.flush();

        // read dragon
        tmp.setName(Reader.readName(clientSocket));
        tmp.setCoordinates(new Coordinates(Reader.readX(clientSocket), Reader.readY(clientSocket)));
        tmp.setAge(Reader.readAge(clientSocket));
        tmp.setColor(Reader.readColor(clientSocket));
        tmp.setType(Reader.readType(clientSocket));
        tmp.setCharacter(Reader.readCharacter(clientSocket));
        tmp.setHead(new DragonHead(Reader.readSize(clientSocket), Reader.readEyesCount(clientSocket), Reader.readToothCount(clientSocket)));

        out.write("end_read_arg\n");
        out.flush();
    }
}
