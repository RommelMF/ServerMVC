package javaBooks.LiveWithDucks.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Home on 30.01.2017.
 */
public class Console {
    private  BufferedReader reader;

    public Console() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputFromTheConsole (String message) {
        String input = null;
        while (input == null && input.equals("")) {
            try {
                System.out.println(message);
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }
}
