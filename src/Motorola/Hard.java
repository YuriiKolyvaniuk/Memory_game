package Motorola;

import java.util.*;

public class Hard{

    private int guess_chances = 15;
    private List<Boolean> covered = Arrays.asList(true,true,true,true,
            true,true,true,true,
            true,true,true,true,
            true,true,true,true);

    private void cover(int index){
        covered.set(index,true);
    }
    private void uncover(int index){
        covered.set(index,false);

    }

    private void win(){
        System.out.println(
                "\n—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—---------------------------You Win!!!-----------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------");
    }
    private void lose(){
        System.out.println(
                "\n—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—---------------------------You Lose:(-----------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n");
    }

    private boolean is_covered(){
        List<Boolean> temp = Arrays.asList(false,false,false,false,
                false,false,false,false,
                false,false,false,false,
                false,false,false,false);
        if(covered.equals(temp)) {
            return false;
        }else {
            return true;
        }
    }

    private String user_uncovers(){

        String result = "";
        Scanner user_input = new Scanner(System.in);
        result = user_input.next();
        switch (result){
            case "A1":
            case "a1":
                if(!covered.get(0)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(0);
                    return result;
                }
            case "A2":
            case "a2":
                if(!covered.get(1)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(1);
                    return result;
                }
            case "A3":
            case "a3":
                if(!covered.get(2)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(2);
                    return result;
                }
            case "A4":
            case "a4":
                if(!covered.get(3)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(3);
                    return result;
                }
            case "B1":
            case "b1":
                if(!covered.get(4)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(4);
                    return result;
                }
            case "B2":
            case "b2":
                if(!covered.get(5)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(5);
                    return result;
                }
            case "B3":
            case "b3":
                if(!covered.get(6)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(6);
                    return result;
                }
            case "B4":
            case "b4":
                if(!covered.get(7)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(7);
                    return result;
                }
            case "C1":
            case "c1":
                if(!covered.get(8)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(8);
                    return result;
                }
            case "C2":
            case "c2":
                if(!covered.get(9)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(9);
                    return result;
                }
            case "C3":
            case "c3":
                if(!covered.get(10)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(10);
                    return result;
                }
            case "C4":
            case "c4":
                if(!covered.get(11)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(11);
                    return result;
                }
            case "D1":
            case "d1":
                if(!covered.get(12)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(12);
                    return result;
                }
            case "D2":
            case "d2":
                if(!covered.get(13)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(13);
                    return result;
                }
            case "D3":
            case "d3":
                if(!covered.get(14)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(14);
                    return result;
                }
            case "D4":
            case "d4":
                if(!covered.get(15)){
                    System.out.println("You have already selected this item.\nPlease choose another element. ");
                    result = user_uncovers();
                    return result;
                }else {
                    uncover(15);
                    return result;
                }
            default:
                System.out.println("ERROR...Incorrect!\n" +
                        "Please choose another element.");
                result = user_uncovers();
                return result;

        }
    }
    private void user_covers(String input){
        switch (input){
            case "A1":
            case "a1":
                cover(0);
                break;
            case "A2":
            case "a2":
                cover(1);
                break;
            case "A3":
            case "a3":
                cover(2);
                break;
            case "A4":
            case "a4":
                cover(3);
                break;
            case "B1":
            case "b1":
                cover(4);
                break;
            case "B2":
            case "b2":
                cover(5);
                break;
            case "B3":
            case "b3":
                cover(6);
                break;
            case "B4":
            case "b4":
                cover(7);
                break;
            case "C1":
            case "c1":
                cover(8);
                break;
            case "C2":
            case "c2":
                cover(9);
                break;
            case "C3":
            case "c3":
                cover(10);
                break;
            case "C4":
            case "c4":
                cover(11);
                break;
            case "D1":
            case "d1":
                cover(12);
                break;
            case "D2":
            case "d2":
                cover(13);
                break;
            case "D3":
            case "d3":
                cover(14);
                break;
            case "D4":
            case "d4":
                cover(15);
                break;
        }
    }
    private String outputFrom(String input, List<String> list){
        String temp = new String();
        switch (input){
            case "A1":
            case "a1":
                temp = list.get(0);
                break;
            case "A2":
            case "a2":
                temp =  list.get(1);
                break;
            case "A3":
            case "a3":
                temp =  list.get(2);
                break;
            case "A4":
            case "a4":
                temp =  list.get(3);
                break;
            case "B1":
            case "b1":
                temp =  list.get(4);
                break;
            case "B2":
            case "b2":
                temp =  list.get(5);
                break;
            case "B3":
            case "b3":
                temp =  list.get(6);
                break;
            case "B4":
            case "b4":
                temp =  list.get(7);
                break;
            case "C1":
            case "c1":
                temp =  list.get(8);
                break;
            case "C2":
            case "c2":
                temp =  list.get(9);
                break;
            case "C3":
            case "c3":
                temp =  list.get(10);
                break;
            case "C4":
            case "c4":
                temp =  list.get(11);
                break;
            case "D1":
            case "d1":
                temp =  list.get(12);
                break;
            case "D2":
            case "d2":
                temp =  list.get(13);
                break;
            case "D3":
            case "d3":
                temp =  list.get(14);
                break;
            case "D4":
            case "d4":
                temp =  list.get(15);
                break;
        }
        return temp;
    }

    private void play_view(List<String> list){
        System.out.println("\n—------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLevel: hard\n\t\t\t\t\tGuess chances:"+ guess_chances);
        System.out.print("\033[0;1m");
        System.out.printf("%16d%15d%15d%15d%n",1,2,3,4);
        System.out.print("A" + "\033[0;0m");
        int numFor_hardMod = 8;
        for(int i = 0; i< numFor_hardMod *2; i++){
            if(!covered.get(i)) {
                System.out.printf("%15s", list.get(i));
            }else{
                System.out.printf("%15s", "X");
            }
            if(i == numFor_hardMod/2 - 1 || i == numFor_hardMod - 1 || i == numFor_hardMod/2*3 - 1 || i == numFor_hardMod*2 - 1){
                System.out.println();
                if (i == numFor_hardMod/2 -1){
                    System.out.print("\033[0;1m"+"B" + "\033[0;0m");
                }else if(i == numFor_hardMod -1){
                    System.out.print("\033[0;1m"+"C" + "\033[0;0m");
                }else if (i == numFor_hardMod/2*3 -1){
                    System.out.print("\033[0;1m"+"D" + "\033[0;0m");
                }
            }
        }
        System.out.println("—------------------------------------------------------------------");
    }

    private void gameplay(List<String> list){

        play_view(list);

        String user_chose;
        user_chose = user_uncovers();
        play_view(list);

        String user_chose2;
        user_chose2 = user_uncovers();
        play_view(list);

        System.out.println("UC = " + user_chose+"\nUC2 = " + user_chose2);

        if (outputFrom(user_chose,list).equals(outputFrom(user_chose2,list))){

        }else{
            user_covers(user_chose);
            user_covers(user_chose2);
        }

    }

    Hard(List<String> list) throws Exception {
        List<String> memory_game = new ArrayList<>();
        memory_game.addAll(list);
        memory_game.addAll(list);

        Collections.shuffle(memory_game);

        boolean flag = true;

        long start = System.currentTimeMillis();

        while(flag) {
            if( guess_chances > 0 && is_covered()) {
                gameplay(memory_game);
                guess_chances--;
            }else if(guess_chances>=0 && !is_covered()){
                flag=false;
                long end = System.currentTimeMillis();
                double guessing_time = (double)(end - start)/1000;
                win();
                System.out.println("You solved the memory game after " +(10-guess_chances) + " chances. It took you " + guessing_time + "seconds");

                Result result = new Result(guessing_time,(10-guess_chances));
                BestResult bestResult = new BestResult(result.name,result.guessing_date,result.guessing_time,result.guessing_tries,"Easy");
                System.out.println("Top 10 result: ");
                bestResult.show();

            }else {
                flag=false;
                lose();
                BestResult bestResult= new BestResult();
                System.out.println("Top 10 result: ");
                bestResult.show();
            }
        }

        System.out.println();
    }

}
