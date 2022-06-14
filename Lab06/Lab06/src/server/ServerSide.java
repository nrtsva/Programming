package server;

import server.manager.CollectionManager;
import server.manager.ServerConnection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
        System.out.println("Загрузка коллекции");
        CollectionManager collection = new CollectionManager("example.xml");

        try (ServerSocket tmpServer = new ServerSocket(3030)) {  /** listen 3030 port*/
            System.out.println("Сервер ожидает подключения клиентов");
            System.out.println("Порт: " + tmpServer.getLocalPort());
            System.out.println("Адрес: " + InetAddress.getLocalHost());

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
                //System.out.println("\nПодключился клиент с ip: " + tmpClient.getInetAddress());
                System.out.println(tmpClient + " подключился к серверу");
                Runnable r = new ServerConnection(collection, tmpClient);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (IOException e) {
            System.err.println("Host is busy. Try later.");
            System.exit(1);
        }
    }
}
