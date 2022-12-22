package SimpleMemoryGame.BestResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Result {

    private String name;
    private String guessing_date;
    private double guessing_time;
    private int guessing_tries;

    private String mode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public String getGuessing_date() {
        return guessing_date;
    }

    public double getGuessing_time() {
        return guessing_time;
    }

    public int getGuessing_tries() {
        return guessing_tries;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuessing_date(String guessing_date) {
        this.guessing_date = guessing_date;
    }

    public void setGuessing_time(double guessing_time) {
        this.guessing_time = guessing_time;
    }

    public void setGuessing_tries(int guessing_tries) {
        this.guessing_tries = guessing_tries;
    }

    @Override
    public String toString() {
        return getName() + " | " + getGuessing_date() + " | " + getGuessing_time() + " | " + getGuessing_tries() + " | " + getMode() + " | ";
    }

    public Result(double time, int tries, String mode) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your name: ");
        setName(scanner.next());
        System.out.println();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        setGuessing_date(formatter.format(date));
        setGuessing_time(time);
        setGuessing_tries(tries);
        setMode(mode);
    }
    public boolean isEmpty(){
        return getGuessing_tries() == 0;
    }
    Result(){

    }
}