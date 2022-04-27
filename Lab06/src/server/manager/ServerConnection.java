package server.manager;

import server.commands.Command;
import server.commands.commandsWithArg.*;
import server.commands.commandsNoArg.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for starting a server
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class ServerConnection {
    private static Socket clientSocket;       /** socket for communication */
    private static ServerSocket serverSocket; /** server socket */
    private static BufferedReader in;         /** reading stream from socket */
    private static BufferedWriter out;        /** writing stream to socket */

    private static CollectionManager serverCollection;

    /** all commands */
    private static Map<String, Command> map = new HashMap<String, Command>();

    private static boolean goFlag = true, serverFlag = true;

    /** function param */
    private static int inputID = -1;
    private static String inputName = "", inputFileName = "";

    /**
     * Method for init server
     *
     * @param collection - CollectionManager
     */
    public static void init(CollectionManager collection) {
        try {
            serverSocket = new ServerSocket(3030); /** listen 3030 port*/
        } catch (IOException e) {
            System.err.println("Host is busy. Try later.");
            System.exit(1);
        }

        serverCollection = collection;

        Command help = new HelpCommand();
        Command info = new InfoCommand();
        Command show = new ShowCommand();
        Command add = new AddCommand();
        Command update = new UpdateIDCommand();
        Command remove_by_id = new RemoveIDCommand();
        Command clear = new ClearCommand();
        Command save = new SaveCommand();
        Command execute_script = new ExecuteScriptCommand();
        Command exit = new ExitCommand();
        Command remove_first = new RemoveFirstCommand();
        Command shuffle = new ShuffleCommand();
        Command reorder = new ReorderCommand();
        Command count_by_head = new CountHeadCommand();
        Command filter_contains_name = new FilterNameCommand();
        Command print_ascending = new PrintAscendingCommand();

        map.put(help.getName(), help);
        map.put(info.getName(), info);
        map.put(show.getName(), show);
        map.put(add.getName(), add);
        map.put(update.getName(), update);
        map.put(remove_by_id.getName(), remove_by_id);
        map.put(clear.getName(), clear);
        map.put(save.getName(), save);
        map.put(execute_script.getName(), execute_script);
        map.put(exit.getName(), exit);
        map.put(remove_first.getName(), remove_first);
        map.put(shuffle.getName(), shuffle);
        map.put(reorder.getName(), reorder);
        map.put(count_by_head.getName(), count_by_head);
        map.put(filter_contains_name.getName(), filter_contains_name);
        map.put(print_ascending.getName(), print_ascending);
    }

    /**
     * Method for creating an active connection+
     */
    public static void work() {
        while (serverFlag) {
            try {
                System.out.println("Waiting a client...");
                clientSocket = serverSocket.accept(); /** waiting client */
                System.out.println("Подключился клиент с ip: " + clientSocket.getInetAddress());

                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    /** accept messages */
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); /** send messages */

                    serverGo();
                } finally {
                    System.out.println("Client is closed..");
                    /** close the client*/
                    clientSocket.close();
                    /** close streams */
                    in.close();
                    out.close();
                }
                //} finally {
                //    System.out.println("Server is closed..");
                //    /** close the server*/
                //    serverSocket.close();
                //}
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    /** Methods go */
    private static void serverGo() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String messages;
        Command c;

        while (goFlag) {
            messages = in.readLine(); /** waiting when client writing sth */
            System.out.println(messages); // debug

            messages = separateParam(messages);
            c = map.get(messages);

            if (c == null) {
                out.write("Некоректная команда. Для просмотра доступных команд, введите 'help'\n");
                out.write("next\n");
                out.flush();
            } else {
                c.go(clientSocket);
                out.write("next\n");
                out.flush();
            }
        }
    }

    /** Methods for separating parameters from function name
     *
     * @param  - all string
     * @return String name
     */
    private static String separateParam( String s ) {
        String[] ss = s.split(" ");
        if (ss.length == 2) {
            s = ss[0];

            try {
                Integer.parseInt(ss[1]);
                inputID = Integer.parseInt(ss[1]);
            } catch (NumberFormatException e) {
                inputName = ss[1];
                inputFileName = ss[1];
            }
        }

        return s;
    }

    /** Methods for getting Server fields */
    public static Map<String, Command> getMap() {
        return map;
    }
    public static CollectionManager getServerCollection() {
        return serverCollection;
    }
    public static int getInputID() {
        return inputID;
    }
    public static String getInputName() {
        return inputName;
    }
    public static String getInputFileName() {
        return inputFileName;
    }

    /** Methods for setting Server fields */
    public static void setInputID( int id ) {
        inputID = id;
    }
    public static void setInputName(String s ) {
        inputName = s;
    }
    public static void setInputFileName( String s ) {
        inputFileName = s;
    }

    /** Methods for setting Server fields */
    public static void setGoFlag( boolean flag ) {
        goFlag = flag;
    }
}
