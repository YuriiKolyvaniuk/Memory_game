package Motorola;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Result {

    String name;
    String guessing_date;
    double guessing_time;
    int guessing_tries;

    Result(double time, int tries){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your name: ");
        this.name = scanner.next();
        System.out.println();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.guessing_date = formatter.format(date);
        this.guessing_time = time;
        this.guessing_tries = tries;
    }
}
