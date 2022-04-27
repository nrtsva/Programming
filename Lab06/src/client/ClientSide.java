package client;

import client.manager.ClientConnection;

import java.net.ConnectException;

/**
 * Class for starting a client
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ClientSide {
    /** Server entry point
     *
     *  @param args
     */
    public static void main(String[] args) {
        System.out.println("Starting a client moodle.\nConnection to server...");
        if (ClientConnection.init()) {
            ClientConnection.work();
        }
    }
}
