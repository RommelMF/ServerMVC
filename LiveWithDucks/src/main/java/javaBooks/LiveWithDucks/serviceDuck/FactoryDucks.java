package javaBooks.LiveWithDucks.serviceDuck;

import javaBooks.LiveWithDucks.modelDuck.Duck;
import javaBooks.LiveWithDucks.modelDuck.GrayDuck;
import javaBooks.LiveWithDucks.modelDuck.MallardDuck;
import javaBooks.LiveWithDucks.modelDuck.MandarinDuck;
import javaBooks.LiveWithDucks.storageDucks.Lake;
import java.util.List;
import java.util.Random;


public class FactoryDucks {

    private Lake lake;
    private Thread thread;
    private ThreadRun threadRun;

    public FactoryDucks() {
        lake = new Lake();
    }

    public void createDuck(int random) {
       Duck duck = selectDuck(random);
        duck.setId(duck.getCountDuck());
        addToStorage(duck);
        startThread();
    }

    public Duck selectDuck(int random) {
        Duck duck = null;
        switch(random) {
            case 1:
                duck = new GrayDuck();
                break;
            case 2:
                duck = new MallardDuck();
                break;
            case 3:
                duck = new MandarinDuck();
                break;
        }
        return duck;
    }

    public void addToStorage(Duck duck) {
        lake.addDuck(duck);
    }

    public void startThread() {
        if(threadRun == null) {
            threadRun = new ThreadRun(lake);
            thread = new Thread(threadRun);
            thread.start();
        }
    }
    public void stopThread() {
        thread.interrupt();
    }
    public void deleteDuck() {
        lake.removeDuck();
    }
}

class ThreadRun implements Runnable {

    private Lake lake;
    private List<Duck> ducks;

    public ThreadRun(Lake lake){
        this.lake = lake;
        ducks = lake.getDuckList();
    }

    @Override
    public void run() {
        long time1 = (long)(Math.random()* 7000);
        Random random = new Random();
        while(!Thread.currentThread().isInterrupted()) {
            if(!ducks.isEmpty()) {
                for (Duck duck : ducks) {
                    try {
                        Thread.currentThread().sleep(time1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(duck.getTypeDuck());
                    int r = random.nextInt(2);
                    switch(r){
                        case 0:
                            duck.performSwim();
                            break;
                        case 1:
                            duck.performQuack();
                            break;
                    }
                }
            }
        }
    }
}
