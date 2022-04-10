package Commands;

import DragonParameters.DragonHead;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand() {
        super("execute_script", "считать и исполнить скрипт из указанного файла");
    }

    @Override
    public void go() {
        ArrayList<String> script = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(Paths.get(CommandList.getInputFileName()));
            do {
                script.add(sc.nextLine());
            } while (sc.hasNext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : script) {
            String[] ss = s.split(" ");
            String com = ss[0];
            if (ss.length == 2) {
                try {
                    Integer.parseInt(ss[1]);
                    CommandList.setInputID(Integer.parseInt(ss[1]));
                } catch (NumberFormatException e) {
                    CommandList.setInputName(ss[1]);
                    CommandList.setInputFileName(ss[1]);
                }
            }
            if (ss.length == 4) {
                DragonHead tmpHead = new DragonHead();
                tmpHead.setSize(Integer.parseInt(ss[1]));
                tmpHead.setEyesCount(Long.parseLong(ss[2]));
                tmpHead.setToothCount(Long.parseLong(ss[3]));
                CommandList.setInputHead(tmpHead);
            }

            Command c = CommandList.getMap().get(com);

            if (c == null) {
                System.err.println("Некорректная команда: " + com);
            } else {
                c.go();
            }
        }
    }
}
