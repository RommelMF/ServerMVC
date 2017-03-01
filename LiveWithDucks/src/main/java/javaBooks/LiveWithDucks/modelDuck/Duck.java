package javaBooks.LiveWithDucks.modelDuck;

/**
 * Abstract parent class Duck
 */
public abstract class Duck {

    private static int countDuck;
    private int id;
    private String typeDuck;

    QuackBehavior quackBehavior;
    SwimBehavior swimBehavior;

    public Duck() {
        this.countDuck = ++countDuck;
    }

    public void performSwim() {
        swimBehavior.swim();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public int getCountDuck() {
        return countDuck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDuck() {
        return typeDuck;
    }

    public void setTypeDuck(String typeDuck) {
        this.typeDuck = typeDuck;
    }
//    методы чтобы менять поведение подкласса динамически
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
    public void setSwimBehavior(SwimBehavior sb) {
        swimBehavior = sb;
    }
}
