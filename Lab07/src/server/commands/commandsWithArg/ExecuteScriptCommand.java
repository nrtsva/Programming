package server.commands.commandsWithArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand() {
        super("execute_script", "считать и исполнить скрипт из указанного файла");
    }

    @Override
    /** Method go
     *
     * @param serverConnection - Sever conection
     */
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        ArrayList<String> script = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(Paths.get(serverConnection.getInputFileName()));
            do {
                script.add(sc.nextLine());
            } while (sc.hasNext());
        } catch (IOException e) {
            out.write("Не удалось открыть файл :(\n");
            out.flush();
            return;
        }

        for (String s : script) {
            String[] ss = s.split(" ");
            String com = ss[0];
            if (ss.length == 2) {
                try {
                    Integer.parseInt(ss[1]);
                    serverConnection.setInputID(Integer.parseInt(ss[1]));
                } catch (NumberFormatException e) {
                    serverConnection.setInputName(ss[1]);
                    serverConnection.setInputFileName(ss[1]);
                }
            }

            Command c = serverConnection.getMap().get(com);

            if (c == null) {
                out.write("Некорректная команда: " + com + "\n");
                out.flush();
                return;
            } else {
                out.write("Команда: " + com + "\n");
                out.flush();
                c.go(serverConnection);
            }
        }
    }
}
