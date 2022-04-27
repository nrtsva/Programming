package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for describing a ExitCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ExitCommand extends Command {
    /**
     * Constructor for making ExitCommand
     */
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        ServerConnection.setGoFlag(false);

        out.write("Работа программы завершена. Соединение будет разорвано\n");
        out.write("stop\n");
        out.flush();
    }
}
