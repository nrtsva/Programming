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
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        serverConnection.setGoFlag(false);

        out.write("Соединение будет разорвано\n");
        out.write("stop\n");
        out.flush();

        System.out.print("Клиент отключился от " + serverConnection.getClientSocket().getPort() + " порта\n");
    }
}
