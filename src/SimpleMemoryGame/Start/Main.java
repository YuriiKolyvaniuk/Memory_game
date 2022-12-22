package SimpleMemoryGame.Start;

import SimpleMemoryGame.difficulty.Easy;
import SimpleMemoryGame.difficulty.Hard;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
;

public class Main {

    private static void randElFromList(List<String> list, int number, List<String> main_list) {
        Random rand = new Random();
        while (list.size() < number) {
            int temp = rand.nextInt(main_list.size());
            if (!list.contains(main_list.get(temp))) {
                list.add(main_list.get(temp));
            }
        }
    }




    public static void main(String[] args) throws Exception {
        final List<String> str_list = new ArrayList<>();
        File file = new File("Words.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            str_list.add(bufferedReader.readLine());
        }

        //Choice of action. Choice of game difficulty.
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Choose your action: \n1) Play memory game. \n2) Exit.");
            String action = userInput.next();

            if (action.equals("1")) {
                List<String> randStr = new ArrayList<>();
                System.out.println("Choose your difficult: \n1) Easy. \n2) Hard.");
                String gameDifficult = userInput.next();

                if (gameDifficult.equalsIgnoreCase("easy") || gameDifficult.equals("1")) {
                    randElFromList(randStr, 4, str_list);
                    new Easy(randStr);
                } else if (gameDifficult.equalsIgnoreCase("hard") || gameDifficult.equals("2")) {
                    randElFromList(randStr, 8, str_list);
                    new Hard(randStr);
                } else {
                    System.out.println("ERROR\t...Incorrect difficult.");
                }
            } else if (action.equals("2")) {
                break;
            } else {
                System.out.println("ERROR\t...Incorrect vault!");
            }
        }
    }
}
