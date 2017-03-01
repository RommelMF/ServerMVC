package javaBooks.LiveWithDucks.storageDucks;

import javaBooks.LiveWithDucks.modelDuck.Duck;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Home on 30.01.2017.
 */
public class Lake {

    private List<Duck> duckList;

    public Lake () {
        this.duckList = new LinkedList<>();
    }

    public boolean addDuck(Duck duck) {
        boolean add = false;
        if (duck != null) {
            duckList.add(duck);
            add = true;
        }
        return add;
    }

    public void removeDuck() {
        Random  random = new Random();
        int rand = random.nextInt(duckList.size()+1);
        if(duckList.size() == 1) {
            rand = 0;
        }
        duckList.remove(rand);

    }

    public List<Duck> getDuckList() {
        return duckList;
    }
}
