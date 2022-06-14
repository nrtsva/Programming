package server.commands.commandsWithArg;

import java.io.IOException;
import java.net.Socket;

/**
 * Interface for commands with argument
 */
public interface CommandWithArg {
    void getArguments( Socket clientSocket ) throws IOException;
}
