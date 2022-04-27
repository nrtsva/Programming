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
 * Class for describing a UpdateIDCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class UpdateIDCommand extends Command implements CommandWithArg {
    Dragon tmp;
    int ID;
    /**
     * Constructor for making UpdateIDCommand
     */
    public UpdateIDCommand() {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    /** Method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        int index = -1;

        ID = ServerConnection.getInputID();
        tmp = new Dragon();
        tmp.setID(ID);

        for (Dragon d : ServerConnection.getServerCollection().getDragons()){
            if (d.getID() == ID){
                index = ServerConnection.getServerCollection().getDragons().indexOf(d);
            }
        }

        if (index == -1) {
            out.write("Дракона с таким id нет\n");
            out.flush();
            return;
        } else {
            getArguments(clientSocket);
            ServerConnection.getServerCollection().getDragons().set(index, tmp);
        }

        out.write("Элемент с id = " + ID + " изменен\n");
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
