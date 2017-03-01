package javaBooks.LiveWithDucks.modelDuck;


public class Swim implements SwimBehavior {
    public void swim() {
        int lengthWay = (int)(Math.random() * 100);
        System.out.println("Проплыла " + lengthWay + " метра(ов). ");
    }
}
