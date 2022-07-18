package Motorola;

import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.nio.Buffer;
import java.util.*;

public class Main {

    private static void randElFromList(List<String> list, int number,List<String> main_list){

        int element_equals = 0;
        for(int i = 0;i<number;i++){
            int temp = (int)(Math.random()*99+1);
            if(list.size() !=0){
                for(int j = 0;j<list.size();j++){
                    if(main_list.get(temp) == list.get(j)){
                        element_equals ++;
                    }
                }
                if(element_equals == 0){
                    list.add(main_list.get(temp));
                }else{
                    i--;
                }
                element_equals = 0;
            }else{
                list.add(main_list.get(temp));
            }
            System.out.println(list);
        }
    }



    public static void main(String[] args) throws Exception {
        List<String> str_list = new ArrayList<>();
        File file = new File("Words.txt");
        boolean is_play = true;
        int best_result = 0;

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            str_list.add(bufferedReader.readLine());
        }
        ////////////////////Choice of action. Choice of game difficulty.////////////////////
        do{
            System.out.println("Choose your action: \n1)Play memory game. \n2)Exit.");
            Scanner user_input = new Scanner(System.in);
            int switch_controller = user_input.nextInt();

            switch(switch_controller){
                case 1:
                    List<String> rand_str = new ArrayList<>();
                    System.out.println("Choose your difficult: \n1)Easy. \n2)Hard.");
                    String game_difficult = user_input.next();
                    switch (game_difficult){
                        case "easy":
                        case "Easy":
                        case "1":
                            randElFromList(rand_str,4,str_list);
                            Easy ez_mod = new Easy(rand_str);
                            break;
                        case "hard":
                        case "Hard":
                        case "2":
                            randElFromList(rand_str,8,str_list);
                            Hard hard_mod = new Hard(rand_str);
                            break;
                        default:
                            System.out.println("ERROR\t...Incorrect difficult.");
                            break;
                    }
                    break;
                case 2:
                    is_play = false;
                    break;
                default:
                    System.out.println("ERROR\t...Incorrect vault!");
                    break;
            }
        }while(is_play);
    }
}
