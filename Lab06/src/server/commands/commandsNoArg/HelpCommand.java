package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;

/**
 * Class for describing a HelpCommands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class HelpCommand extends Command implements CommandNoArg {

    /**
     * Constructor for making HelpCommand
     */
    public HelpCommand(){
        super("help", "вывести справку по доступным командам");
    }

    @Override
    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    public void go( Socket clientSocket ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        for (Map.Entry<String, Command> entry: ServerConnection.getMap().entrySet()) {
            out.write(entry.getValue().getName() + ": " + entry.getValue().getDescription() + "\n");
            out.flush();
        }
    }
}
