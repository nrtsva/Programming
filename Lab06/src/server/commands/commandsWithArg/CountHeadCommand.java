package server.commands.commandsWithArg;

import server.commands.Command;
import server.data.Dragon;
import server.data.DragonHead;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a CountHeadCommand
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class CountHeadCommand extends Command implements CommandWithArg {
    DragonHead tmp;

    /**
     * Constructor for making CountHeadCommand
     */
    public CountHeadCommand() {
        super("count_by_head", "вывести количество элементов, значение поля head которых равно заданному(введите значения size, eyesCount, toothCount через пробел)");
    }

    @Override
    /** Method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        int count = 0;

        tmp = new DragonHead();
        getArguments(clientSocket);

        for (Dragon d : ServerConnection.getServerCollection().getDragons()) {
            if (d.getHead().equals(tmp)) {
                count++;
            }
        }

        out.write("Колличество друконов с такими головами: " + count + "\n");
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

        tmp.set(Reader.readSize(clientSocket), Reader.readEyesCount(clientSocket), Reader.readToothCount(clientSocket));

        out.write("end_read_arg\n");
        out.flush();
    }
}
