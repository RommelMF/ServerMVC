package avito.Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 24.01.2017.
 */
public class CollectionTest {
    int id = 1;
    int item = 3;
    int colour = 5;
    int flour = 8;

    public void getNumber() {

        List<Integer> list = new ArrayList<Integer>();
        list.add(id);
        list.add(item);
        list.add(colour);
        list.add(flour);

        for (Integer integer : list.subList(0, 2)) {
            System.out.println(integer);

        }
    }


    public static void main(String[] args) {
        CollectionTest collect = new CollectionTest();
        collect.getNumber();

    }
}
