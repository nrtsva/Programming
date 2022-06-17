package server;

import server.manager.CollectionManager;
import server.manager.DBManager;
import server.manager.ServerConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * Class for starting a server
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ServerSide {
    private static final String serverPropertiesPath = "bin/properties/server.properties";
    private static final String dbPropertiesPath = "bin/properties/db.properties";

    /** Server entry point
     *
     *  @param args
     */
    public static void main(String[] args) throws IOException {
        Properties serverProperties = new Properties();
        Properties dbProperties = new Properties();

        serverProperties.load(new FileInputStream(serverPropertiesPath));
        String serverHost = serverProperties.getProperty("host", "localhoct");
        int serverPort = Integer.parseInt(serverProperties.getProperty("port", "2022"));

        dbProperties.load(new FileInputStream(dbPropertiesPath));

        System.out.println("Подключение к базе данных");
        DBManager db = new DBManager(dbProperties);
        CollectionManager collection = new CollectionManager(db);

        try (ServerSocket tmpServer = new ServerSocket(serverPort)) {  /** listen 2022 port*/
            System.out.println("Сервер ожидает подключения клиентов");
            System.out.println("Порт: " + serverPort);
            System.out.println("Адрес: " + serverHost);

            Thread pointer = new Thread(() -> {
               while (!Thread.currentThread().isInterrupted()) {
                   System.out.print(".");
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       System.out.print("\n");
                       Thread.currentThread().interrupt();
                   }
               }
            });
            pointer.setDaemon(true);
            pointer.start();
            while (true) {
                Socket tmpClient = tmpServer.accept();
                pointer.interrupt();
                System.out.println(tmpClient + " подключился к серверу");
                Runnable r = new ServerConnection(collection, db, tmpClient);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (IOException e) {
            System.err.println("Host is busy. Try later.");
            System.exit(1);
        }
    }
}
