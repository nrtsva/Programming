package server.manager;

import server.data.Dragon;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Class for working with collection
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class CollectionManager {
    /** collection */
    private static ArrayList<Dragon> dragons;
    private java.time.LocalDateTime CreatingTime;

    /**
     * Constructor for making CollectionManager
     *
     * @param db - db manager
     */
    public CollectionManager( DBManager db ) {
        System.out.println("Загрузка коллекции..");
        updateCollection(db);
        CreatingTime = db.getDBCreationTime();
    }

    public void updateCollection( DBManager db ) {
        dragons = db.getElements();
    }

    /** Methods for getting CollectionManager fields */
    public ArrayList<Dragon> getDragons() {
        return dragons;
    }
    public java.time.LocalDateTime getCreatingTime() {
        return CreatingTime;
    }
}
