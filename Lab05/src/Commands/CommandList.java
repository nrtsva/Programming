package Commands;

import DragonParameters.Dragon;
import DragonParameters.DragonHead;
import xmlFiles.xmlReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandList {
    private static Map<String, Command> map = new HashMap<String, Command>();
    private static ArrayList<Dragon> dragons = xmlReader.go();

    private static boolean goFlag = true;
    private static Integer inputID = -1;
    private static DragonHead inputHead = new DragonHead();
    private static String inputName = null, inputFileName = null;


    public static void init() {
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

    public static void go() {
        Scanner sc = new Scanner(System.in);
        String s;
        Command c;

        while (goFlag) {
            s = sc.nextLine();

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
            if (ss.length == 4) {
                s = ss[0];
                inputHead.setSize(Integer.parseInt(ss[1]));
                inputHead.setEyesCount(Long.parseLong(ss[2]));
                inputHead.setToothCount(Long.parseLong(ss[3]));
            }

            c = map.get(s);

            if (c == null) {
                System.err.println("Некорректная команда. Для просмотра доступных команд введите 'help'");
            } else {
                c.go();
            }
        }
    }

    public static Map<String, Command> getMap() {
        return map;
    }
    public static ArrayList<Dragon> getDragons() {
        return dragons;
    }
    public static Integer getInputID() {
        return inputID;
    }
    public static DragonHead getInputHead() {
        return inputHead;
    }
    public static String getInputName() {
        return inputName;
    }
    public static String getInputFileName() {
        return inputFileName;
    }

    public static void setGoFlag( boolean flag ) {
        goFlag = flag;
    }
    public static void setInputID( Integer id ) {
        inputID = id;
    }
    public static void setInputHead( DragonHead head ) {
        inputHead = head;
    }
    public static void setInputName( String name ) {
        inputName = name;
    }
    public static void setInputFileName( String name ) {
        inputFileName = name;
    }
}