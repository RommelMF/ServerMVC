package javaBooks.LiveWithDucks.modelDuck;


public class GrayDuck extends Duck {

    public GrayDuck() {
        setTypeDuck("Gray Duck");
        quackBehavior = new Quack();
        swimBehavior = new Swim();
    }
}
