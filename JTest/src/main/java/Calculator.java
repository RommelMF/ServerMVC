/**
 * Created by Home on 05.01.2017.
 */
public class Calculator {
    // Результат вычисления

    private int result;
    // суммируем аргументы

    public void add(int... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }
    //получить результат вычисления
    public int getResult() {
        return this.result;
    }
    //очистить результат вычисления
    public void cleanResult() {
        this.result = 0;
    }
}
