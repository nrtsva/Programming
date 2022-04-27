package client.manager;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Class for client connection
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ClientConnection {
    private static Socket clientSocket;  /** socket for communication */
    private static Scanner fromKeyboard; /** reading from the keyboard */
    private static BufferedReader in;    /** reading stream from socket */
    private static BufferedWriter out;   /** writing stream to socket */

    private static boolean goFlag = true, clientFlag = true;

    /**
     * Method for init client connection
     */
    public static boolean init() {
        try {
            clientSocket = new Socket("localhost", 3030); /** ask for access to the connection */
            return true;
        } catch (java.net.ConnectException e) {
            System.out.println("Невозможно подключиться к серверу! Попробуйте позже");
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return false;
    }

    /**
     * Method for creating an active connection
     */
    public static void work() {
        while (clientFlag) {
            try {
                if (clientSocket.isClosed()) {
                    try {
                        clientSocket = new Socket("localhost", 3030); /** ask for access to the connection */
                        System.out.println("Соединение востановлено");
                    } catch (java.net.ConnectException e) {
                        //System.out.println("Невозможно подключиться к серверу! Попробуйте позже");
                    } catch (UnknownHostException e) {
                        System.err.println(e);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    fromKeyboard = new Scanner(System.in);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    /** accept messages */
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); /** send messages */

                    clientGo();
                } catch (java.net.SocketException e) {
                    System.out.println("Сервер недоступен");
                } catch (java.lang.NullPointerException e) {
                    //System.out.println("ТУТ1");
                } finally {
                    /** close the client*/
                    clientSocket.close();
                    /** close streams */
                    in.close();
                    out.close();

                    if (clientFlag) {
                        System.out.println("Вы хотите завершить работу клиента?");
                        System.out.print("Введите команду(yes/no): ");
                        String word = fromKeyboard.nextLine();
                        System.out.println(clientFlag);
                        if (word.equals("yes")) {
                            System.out.println("Client is closed..");
                            clientFlag = false;
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Method go
     */
    private static void clientGo() throws IOException {
        while (goFlag) {
            System.out.print("Введите команду: ");
            String word = fromKeyboard.nextLine();
            System.out.println();
            out.write(word + "\n"); /** send message */
            out.flush();

            String serverWord;
            while (!(serverWord = in.readLine()).equals("next")) {
                if (serverWord.equals("stop")) {
                    goFlag = false;
                    clientFlag = false;
                    break;
                }
                if (serverWord.equals("start_read_arg")) {
                    setArg();
                    serverWord = "";
                }
                System.out.println(serverWord);
            }
            System.out.println();
        }
    }

    private static void setArg() throws IOException {
        String serverWord, clientWord;
        while (!(serverWord = in.readLine()).equals("end_read_arg")) {
            System.out.print(serverWord);
            clientWord = fromKeyboard.nextLine();
            out.write(clientWord + "\n"); /** send message */
            out.flush();
        }
    }
}
