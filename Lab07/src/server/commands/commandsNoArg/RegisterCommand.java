package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class RegisterCommand extends Command implements CommandNoArg {
    public RegisterCommand() {
        super("register", "зарегистрироваться");
    }

    @Override
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        if (serverConnection.getDB().userIsExist(serverConnection.getLogin())) {
            out.write("Пользователя с таким именем уже существует! Используйте 'login'\n");
            out.flush();
        } else {
            serverConnection.getDB().registerUser(serverConnection.getLogin(), serverConnection.getPassword());
            out.write("Здравствуйте, " + serverConnection.getLogin() +"\n");
            out.flush();
            out.write("registered\n");
            out.flush();
        }
    }
}