package programmDeals.programm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class console
 */
public class Console {

    private BufferedReader reader;

    public Console() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String keyboard(String message) {
        String answer = null;
        System.out.println(message);
        try {
            while (answer == null) {
                answer = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
