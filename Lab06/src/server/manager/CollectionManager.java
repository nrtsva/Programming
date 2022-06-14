package server.manager;

import server.data.Dragon;
import server.xmlFiles.xmlReader;

import java.util.ArrayList;

/**
 * Class for working with collection
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class CollectionManager {
    private static String inputFName;
    /** collection */
    private static ArrayList<Dragon> dragons;

    /**
     * Constructor for making CollectionManager
     *
     * @param fileName - name of xml file
     */
    public CollectionManager( String fileName ) {
        System.out.println("Чтение коллекции из файла " + fileName);
        inputFName = fileName;
        xmlReader.setFileName(fileName);
        dragons = xmlReader.go();
    }

    /** Methods for getting CollectionManager fields */
    public ArrayList<Dragon> getDragons() {
        return dragons;
    }
    public String getInputFileName() {
        return inputFName;
    }
}
