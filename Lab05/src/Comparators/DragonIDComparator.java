package Comparators;

import DragonParameters.Dragon;

import java.util.Comparator;

public class DragonIDComparator implements Comparator<Dragon> {

    @Override
    public int compare(Dragon d1, Dragon d2) {
        return d1.getID() - d2.getID();
    }
}
