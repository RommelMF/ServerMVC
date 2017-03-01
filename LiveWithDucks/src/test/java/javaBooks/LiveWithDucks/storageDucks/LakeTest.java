package javaBooks.LiveWithDucks.storageDucks;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import javaBooks.LiveWithDucks.modelDuck.Duck;
import javaBooks.LiveWithDucks.modelDuck.MandarinDuck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 24.02.2017.
 */
public class LakeTest {
    Lake lake;
    Duck duck;

    @Before
    public void init() {
        lake = new Lake();
        duck = new MandarinDuck();
    }

    @Test
    public void addDuckTest() {
        boolean item = lake.addDuck(duck);

        Assert.assertTrue(item);
    }
    @Test
    public void removeDuckTest() {
        if(!lake.getDuckList().isEmpty()) {
            lake.removeDuck();
        }

        Assert.assertTrue(lake.getDuckList().isEmpty());
    }
}
