package javaBooks.LiveWithDucks.modelDuck;

/**
 * Created by Home on 30.01.2017.
 */
public class MandarinDuck extends Duck {

    public MandarinDuck() {
        setTypeDuck("Mandarin Duck");
        quackBehavior = new Quack();
        swimBehavior = new Swim();
    }
}
