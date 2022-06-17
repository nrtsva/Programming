package client.manager;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class for client connection
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ClientConnection {
    private Socket clientSocket;  /** socket for communication */
    private Scanner fromKeyboard; /** reading from the keyboard */
    private BufferedReader in;    /** reading stream from socket */
    private BufferedWriter out;   /** writing stream to socket */

    private boolean goFlag = true, clientFlag = true, logFlag = true;

    private String login, password;

    /**
     * Method for creating an active connection
     */
     public void work(Properties properties) {
         String clientHost = properties.getProperty("host", "localhoct");
         int clientPort = Integer.parseInt(properties.getProperty("port", "2022"));

         try (Scanner tmpScanner = new Scanner(System.in)) {
             fromKeyboard = tmpScanner;
             while (clientFlag) {
                 try (Socket tmpSocket = new Socket(clientHost, clientPort)) { /** ask for access to the connection */
                     clientSocket = tmpSocket;
                     clientSocket.setSoTimeout(5000);
                     try (BufferedReader tmpIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));      /** accept messages */
                          BufferedWriter tmpOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) { /** send messages */
                         in = tmpIn;
                         out = tmpOut;
                         System.out.println("Соединение установлено");
                         clientStart();
                         clientGo();
                         System.out.println("Client is closed..");
                     }
                 } catch (IOException e) {
                     System.out.println("Не удалось подключиться к серверу!");
                     System.out.println("Попробовать еще раз? Введите команду yes/no");
                     boolean askFlag = true;
                     while (askFlag) {
                         String answer = fromKeyboard.nextLine();
                         switch (answer) {
                             case "":
                                 break;
                             case "no":
                                 stop();
                                 askFlag = false;
                                 break;
                             case "yes":
                                 askFlag = false;
                                 System.out.println("Подключение к серверу...");
                                 break;
                             default:
                                 System.out.println("Введите yes/no");
                         }
                     }
                 }
             }
         }
     }

     private void clientStart() throws IOException {
         while (logFlag) {
             System.out.println("\nНужно войти или зарегестрироваться для начала работы.");
             System.out.print("Введите команду(login/register): ");
             String command = fromKeyboard.nextLine();

             switch (command) {
                 case "login":
                     login();
                     break;
                 case "register":
                     register();
                     break;
             }
         }
         in.readLine();
     }

     private void login() throws IOException {
         System.out.print("login: ");
         login = fromKeyboard.nextLine();
         System.out.print("password: ");
         password = fromKeyboard.nextLine();

         out.write("login " + login + " " + password + "\n"); /** send message */
         out.flush();

         String serverWord = in.readLine();
         System.out.println(serverWord);

         if ((serverWord = in.readLine()).equals("login")) {
             logFlag = false;
         }
     }

     private void register() throws IOException {
         System.out.print("login: ");
         login = fromKeyboard.nextLine();
         System.out.print("password: ");
         password = fromKeyboard.nextLine();
         System.out.print("repeat password: ");
         String passwordRepeated = fromKeyboard.nextLine();
         while (!password.equals(passwordRepeated)) {
             System.out.println("Пароли не совпадают!");
             System.out.print("repeat password: ");
             passwordRepeated = fromKeyboard.nextLine();
         }

         out.write("register " + login + " " + password + "\n"); /** send message */
         out.flush();

         String serverWord = in.readLine();
         System.out.println(serverWord);

         if ((serverWord = in.readLine()).equals("registered")) {
             logFlag = false;
         }
     }

    /**
     * Method go
     */
    private void clientGo() throws IOException {
        System.out.println("");
        while (goFlag) {
            System.out.print("Введите команду: ");
            String word = fromKeyboard.nextLine();
            //System.out.println();
            out.write(word + " " + login + " " + password + "\n"); /** send message */
            out.flush();

            String serverWord;
            while (!(serverWord = in.readLine()).equals("next")) {
                if (serverWord.equals("stop")) {
                    stop();
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

    private void setArg() throws IOException {
        String serverWord, clientWord;
        while (!(serverWord = in.readLine()).equals("end_read_arg")) {
            System.out.print(serverWord);
            clientWord = fromKeyboard.nextLine();
            out.write(clientWord + "\n"); /** send message */
            out.flush();
        }
    }

    private void stop() {
        goFlag = false;
        clientFlag = false;
        System.out.println("Завершение работы программы..");
    }
}
