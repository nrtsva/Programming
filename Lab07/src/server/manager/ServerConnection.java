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
public class ServerConnection implements Runnable {
    private Socket clientSocket;       /** socket for communication */
    //private ServerSocket serverSocket; /** server socket */
    private BufferedReader in;         /** reading stream from socket */
    private BufferedWriter out;        /** writing stream to socket */

    private CollectionManager serverCollection;
    private DBManager DB;

    /** all commands */
    private Map<String, Command> map = new HashMap<String, Command>();

    private boolean goFlag = true, serverFlag = true;

    /** function param */
    private int inputID = -1;
    private String inputName = "", inputFileName = "";

    /** user param */
    private String login, password;

    /**
     * Method for init server
     *
     * @param collection - CollectionManager
     */
    public ServerConnection(CollectionManager collection, DBManager db, Socket socket) {
        this.clientSocket = socket;
        this.serverCollection = collection;
        this.DB = db;

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
        Command login = new LoginCommand();
        Command register = new RegisterCommand();

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
        map.put(login.getName(), login);
        map.put(register.getName(), register);
    }

    @Override
    public void run() {
        try (BufferedReader tmpIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));      /** accept messages */
             BufferedWriter tmpOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) { /** send messages */
            in = tmpIn;
            out = tmpOut;

            serverGo();
        } catch (IOException ex) {
            System.err.println(clientSocket + " ???????????????????? ???? ??????????????.");
        }
    }

    /** Methods go */
    private void serverGo() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String messages;
        Command c;

        while (goFlag) {
            messages = in.readLine(); /** waiting when client writing sth */
            messages = separateUser(messages);
            System.out.println("???????????? ???? " + clientSocket.getPort() + " ?????????? - " + messages); // debug

            messages = separateParam(messages);
            c = map.get(messages);

            if (c == null) {
                out.write("?????????????????????? ??????????????. ?????? ?????????????????? ?????????????????? ????????????, ?????????????? 'help'\n");
                out.write("next\n");
                out.flush();
            } else {
                c.go(this);
                out.write("next\n");
                out.flush();
            }
        }
    }

    private String separateUser( String s ) {
        String[] ss = s.split(" ");
        login = ss[ss.length - 2]; ss[ss.length - 2] = "";
        password = ss[ss.length - 1]; ss[ss.length - 1] = "";

        String res = "";
        for (String a : ss) {
            res = res + a + " ";
        }

        return res.trim();
    }

    /** Methods for separating parameters from function name
     *
     * @param  - all string
     * @return String name
     */
    private String separateParam( String s ) {
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
    public Map<String, Command> getMap() {
        return map;
    }
    public CollectionManager getServerCollection() {
        return serverCollection;
    }
    public DBManager getDB() {
        return DB;
    }
    public Socket getClientSocket() {
        return clientSocket;
    }
    public int getInputID() {
        return inputID;
    }
    public String getInputName() {
        return inputName;
    }
    public String getInputFileName() {
        return inputFileName;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    /** Methods for setting Server fields */
    public void setInputID( int id ) {
        inputID = id;
    }
    public void setInputName(String s ) {
        inputName = s;
    }
    public void setInputFileName( String s ) {
        inputFileName = s;
    }

    /** Methods for setting Server fields */
    public void setGoFlag( boolean flag ) {
        goFlag = flag;
    }
}
