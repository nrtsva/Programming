package server.commands;

import java.io.IOException;
import java.net.Socket;

/**
 * Abstract class for describing a commands
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public abstract class Command {
    private String name;
    private String description;

    /**
     * Constructor for making Command
     *
     * @param name - command's name
     * @param description - description of command
     */
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /** Methods for getting Commands fields */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    /** Abstract method go
     *
     * @param clientSocket - Client socket
     */
    abstract public void go( Socket clientSocket ) throws IOException;
}
