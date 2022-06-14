package server.xmlFiles;

import server.manager.CollectionManager;
import server.data.Dragon;
import server.manager.ServerConnection;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class xmlWriter extends xmlData {

    public static void go( ServerConnection serverConnection ) {
        DecimalFormat dF = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
        String[] type = {"id", "name", "coordinates", "creationDate", "age", "color", "type", "character", "head"};
        String input = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

        for (Dragon d : serverConnection.getServerCollection().getDragons()) {
            input = input + "\t<dragon>\n";
            input = input + "\t\t<" + type[0] + ">" + d.getID() + "</" + type[0] + ">\n";
            input = input + "\t\t<" + type[1] + ">" + d.getName() + "</" + type[1] + ">\n";
            input = input + "\t\t<" + type[2] + ">" + d.getCoordinates().toString() + "</" + type[2] + ">\n";
            input = input + "\t\t<" + type[3] + ">" + d.getCreationDate().toString() + "</" + type[3] + ">\n";
            input = input + "\t\t<" + type[4] + ">" + d.getAge() + "</" + type[4] + ">\n";
            input = input + "\t\t<" + type[5] + ">" + d.getColor() + "</" + type[5] + ">\n";
            input = input + "\t\t<" + type[6] + ">" + d.getType() + "</" + type[6] + ">\n";
            input = input + "\t\t<" + type[7] + ">" + d.getCharacter() + "</" + type[7] + ">\n";
            input = input + "\t\t<" + type[8] + ">" + d.getHead().toString() + "</" + type[8] + ">\n";
            input = input + "\t</dragon>\n";
        }
        input = input + "</set>\n";
        write(input);
    }


}