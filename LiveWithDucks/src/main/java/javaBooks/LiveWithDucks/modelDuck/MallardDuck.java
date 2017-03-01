package javaBooks.LiveWithDucks.modelDuck;

/**
 * Created by Home on 30.01.2017.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        setTypeDuck("Mallard Duck");
        quackBehavior = new Quack();
        swimBehavior = new Swim();
    }
}
