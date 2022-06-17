package server.commands.commandsNoArg;

import server.commands.Command;
import server.manager.ServerConnection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class LoginCommand extends Command implements CommandNoArg {
    public LoginCommand() {
        super("login", "зайти в аккаунт");
    }

    @Override
    public void go( ServerConnection serverConnection ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverConnection.getClientSocket().getOutputStream()));

        if (!serverConnection.getDB().userIsExist(serverConnection.getLogin())) {
            out.write("Пользователя с таким именем не существует! Используйте 'register'\n");
            out.flush();
        } else if (!serverConnection.getDB().checkPassword(serverConnection.getLogin(), serverConnection.getPassword())) {
            out.write("Введен неверный пароль! Попробуйте еще раз\n");
            out.flush();
        } else {
            out.write("Здравствуйте, " + serverConnection.getLogin() +"\n");
            out.flush();
            out.write("login\n");
            out.flush();
        }
    }
}