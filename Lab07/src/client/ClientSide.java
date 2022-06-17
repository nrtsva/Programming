package client;

import client.manager.ClientConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Properties;

/**
 * Class for starting a client
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ClientSide {
    private static final String clientPropertiesPath = "bin/properties/client.properties";

    /** Server entry point
     *
     *  @param args
     */
    public static void main(String[] args) throws IOException {
        Properties clientProperties = new Properties();
        clientProperties.load(new FileInputStream(clientPropertiesPath));

        System.out.println("Запуск клиентского модуля.\nПодключение к серверу...");
        ClientConnection connection = new ClientConnection();
        connection.work(clientProperties);
    }
}
