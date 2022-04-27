package server;

import server.manager.CollectionManager;
import server.manager.ServerConnection;

/**
 * Class for starting a server
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ServerSide {
    /** Server entry point
     *
     *  @param args
     */
    public static void main(String[] args) {
        CollectionManager collection = new CollectionManager("example.xml");

        ServerConnection.init(collection);
        System.out.println("Starting a server moodle.");

        ServerConnection.work();
    }
}
