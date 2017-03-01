package javaBooks.LiveWithDucks.processors;

import javaBooks.LiveWithDucks.console.Console;
import javaBooks.LiveWithDucks.modelDuck.Duck;
import javaBooks.LiveWithDucks.serviceDuck.FactoryDucks;

import java.util.Random;

/**
 * Class ProcessorDucks
 */
public class ProcessorDucks {

    private FactoryDucks factoryDucks;
    private Console console;
    private Random random;

    public ProcessorDucks() {
        factoryDucks = new FactoryDucks();
        console = new Console();
        random =  new Random();
    }
    public void init() {
        String message = "Введите команду(create - c/delete - d/exit - e) : ";
        String exit = "e";
        String create = "c";
        String delete = "d";
        boolean circle = true;

        while(circle) {
            String output = console.inputFromTheConsole(message).toLowerCase();

            if(output.equals(create)) {
                factoryDucks.createDuck(random.nextInt(3)+1);
            }else if(output.equals(delete)) {
                factoryDucks.deleteDuck();
            }else if(output.equals(exit)) {
               factoryDucks.stopThread();
                circle = false;
            }
        }
    }
}
