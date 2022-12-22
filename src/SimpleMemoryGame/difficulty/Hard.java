package SimpleMemoryGame.difficulty;

import SimpleMemoryGame.BestResult.BestResult;
import SimpleMemoryGame.BestResult.Result;

import java.util.*;

public class Hard{
   //Number of chances.
    private int guessChances = 15;
    private List<Boolean> covered = Arrays.asList(
            true,true,true,true,
            true,true,true,true,
            true,true,true,true,
            true,true,true,true);
    private Map <String, Integer> inputMap = new HashMap<>();
    {
        inputMap.put("a1", 0);
        inputMap.put("a2", 1);
        inputMap.put("a3", 2);
        inputMap.put("a4", 3);
        inputMap.put("b1", 4);
        inputMap.put("b2", 5);
        inputMap.put("b3", 6);
        inputMap.put("b4", 7);
        inputMap.put("c1", 8);
        inputMap.put("c2", 9);
        inputMap.put("c3", 10);
        inputMap.put("c4", 11);
        inputMap.put("d1", 12);
        inputMap.put("d2", 13);
        inputMap.put("d3", 14);
        inputMap.put("d4", 15);

    }
   //Close the word.
    private void cover(int index){
        covered.set(index,true);
    }
    //Open the word.
    private void uncover(int index){
        covered.set(index,false);

    }
    //Notification of winnings.
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
    //Notification of loss.
    private void lost(){
        System.out.println(
                "\n—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—---------------------------You Lost:(-----------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n"+
                        "—------------------------------------------------------------------\n");
    }
    //Is the word closed.
    private boolean is_covered(){
        List<Boolean> temp = Arrays.asList(
                false,false,false,false,
                false,false,false,false,
                false,false,false,false,
                false,false,false,false);
        if(covered.equals(temp)) {
            return false;
        }else {
            return true;
        }
    }
    //Redirect to item to open.
    private String user_uncovers() {
        Scanner user_input = new Scanner(System.in);
        String result = user_input.next();
        if (!inputMap.containsKey(result.toLowerCase())) {
            System.out.println("Invalid input. Please choose a valid element. ");
            result = user_uncovers();
            return result;
        }
        int index = inputMap.get(result.toLowerCase());
        if (!covered.get(index)) {
            System.out.println("You have already selected this item. Please choose another element. ");
            result = user_uncovers();
            return result;
        }
        uncover(index);
        return result;
    }
    //Redirect to element to close.
    private void user_covers(String input) {
        input = input.toLowerCase();
        if (inputMap.containsKey(input)) {
            cover(inputMap.get(input));
        }
    }
    //Returns the element by the given cell.
    private String outputFrom(String input, List<String> list) {
        input = input.toLowerCase();
        if (inputMap.containsKey(input)) {
            return list.get(inputMap.get(input));
        }
        return "";
    }

   //Displaying the game interface.
    private void play_view(List<String> list){
        System.out.println("\n—------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLevel: hard\n\t\t\t\t\tGuess chances:"+ guessChances);
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
   //Game algorithm.
    private void playGame(List<String> list){

        play_view(list);

        String user_chose;
        user_chose = user_uncovers();
        play_view(list);

        String user_chose2;
        user_chose2 = user_uncovers();
        play_view(list);

        System.out.println("UC = " + user_chose+"\nUC2 = " + user_chose2);

        if (!outputFrom(user_chose,list).equals(outputFrom(user_chose2,list))){
            user_covers(user_chose);
            user_covers(user_chose2);
        }
    }
    //Game logic
    public Hard(List<String> list) throws Exception {
        // create a new list with duplicate elements from the input list
        List<String> memory_game = new ArrayList<>(list);
        memory_game.addAll(list);

        // shuffle the elements in the list
        Collections.shuffle(memory_game);

        // flag to track whether the game is still ongoing
        boolean gameOngoing = true;

        // start the timer
        long start = System.currentTimeMillis();

        // loop until the game is over
        while(gameOngoing) {
            // if there are still guess chances remaining and there are covered elements
            if( guessChances > 0 && is_covered()) {
                playGame(memory_game);
                guessChances--;
            }
            // if there are no more covered elements
            else if(guessChances >=0 && !is_covered()){
                // end the game
                gameOngoing=false;
                long end = System.currentTimeMillis();
                double guessing_time = (end - start)/1000;
                win();
                System.out.println("You solved the memory game after " +(10- guessChances) + " chances. It took you " + guessing_time + "seconds");

                Result result = new Result(guessing_time,(10- guessChances), "Hard");
                BestResult bestResult = new BestResult(result);
                System.out.println("Top 10 result: ");
               //Display data.
                bestResult.show();

            }
            // if there are no more guess chances remaining
            else {
                // end the game
                gameOngoing=false;
                lost();
                BestResult bestResult= new BestResult();
                System.out.println("Top 10 result: ");
               //Display data.
                bestResult.show();
            }
        }
        System.out.println();
    }

}
