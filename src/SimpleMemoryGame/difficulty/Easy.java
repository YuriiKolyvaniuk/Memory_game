package SimpleMemoryGame.difficulty;

import SimpleMemoryGame.BestResult.BestResult;
import SimpleMemoryGame.BestResult.Result;

import java.util.*;

public class Easy {
//Number of chances.
    private int guess_chances = 10;
    private List<Boolean> covered = Arrays.asList(true,true,true,true,true,true,true,true);
    private Map<String, Integer> inputToIndex = new HashMap<>();

    {
        inputToIndex.put("a1", 0);
        inputToIndex.put("a2", 1);
        inputToIndex.put("a3", 2);
        inputToIndex.put("a4", 3);
        inputToIndex.put("b1", 4);
        inputToIndex.put("b2", 5);
        inputToIndex.put("b3", 6);
        inputToIndex.put("b4", 7);
    }
//Open the word.
    private void uncover(int index){
        covered.set(index,false);
    }
//Close the word.
    private void cover(int index){
        covered.set(index,true);
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
        List<Boolean> temp = Arrays.asList(false,false,false,false,false,false,false,false);
        if (covered.equals(temp)) {
            return false;
        }else {
            return true;
        }
    }

//Redirect to item to open.
private String user_uncovers() {
    String result = "";
    Scanner user_input = new Scanner(System.in);
    while (true) {
        result = user_input.next();
        Integer index = inputToIndex.get(result.toLowerCase());
        if (index == null) {
            System.out.println("ERROR...Incorrect!\nPlease choose another element.");
            continue;
        }
        if (!covered.get(index)) {
            System.out.println("You have already selected this item.\nPlease choose another element. ");
            continue;
        }
        uncover(index);
        return result;
    }
}

//Redirect to element to close.
   private void user_covers(String input) {
       try {
           int index = inputToIndex.get(input.toLowerCase());
           cover(index);
       } catch (NullPointerException e) {
           System.out.println("ERROR...Incorrect input!");
       }
   }

//Returns the element by the given cell.
private String outputFrom(String input, List<String> list) {
    try {
        int index = inputToIndex.get(input.toLowerCase());
        return list.get(index);
    } catch (NullPointerException e) {
        return "";
    }
}
//Displaying the game interface.
    private void play_view(List<String> list) {
        int numRows = 2;
        int numColumns = 4;

        System.out.println("\n—------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLevel: easy\n\t\t\t\t\tGuess chances:"+ guess_chances);
        System.out.print("\033[0;1m");
        System.out.printf("%16d%15d%15d%15d%n", 1, 2, 3, 4);
        System.out.print("A" + "\033[0;0m");
        for (int i = 0; i < numRows * numColumns; i++) {
            if (!covered.get(i)) {
                System.out.printf("%15s", list.get(i));
            } else {
                System.out.printf("%15s", "X");
            }
            if (i == numColumns - 1 || i == numRows * numColumns - 1) {
                System.out.println();
                if (i == numColumns - 1) {
                    System.out.print("\033[0;1m" + "B" + "\033[0;0m");
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

        if (!outputFrom(user_chose,list).equals(outputFrom(user_chose2,list))){
            user_covers(user_chose);
            user_covers(user_chose2);
        }
    }

    public Easy(List<String> list) throws Exception {
        // create a new list with duplicate elements from the input list
        List<String> cards = new ArrayList<>(list);
        cards.addAll(list);

        // shuffle the elements in the list
        Collections.shuffle(cards);

        // flag to track whether the game is still ongoing
        boolean gameOngoing = true;

        // start the timer
        long start = System.currentTimeMillis();

        // loop until the game is over
        while(gameOngoing) {
            // if there are still guess chances remaining and there are covered elements
            if( guess_chances > 0 && is_covered()) {
                playGame(cards);
                guess_chances--;
            }
            // if there are no more covered elements
            else if(guess_chances>=0 && !is_covered()){
                // end the game
                gameOngoing = false;
                long end = System.currentTimeMillis();
                double guessing_time = (end - start)/1000;
                win();
                System.out.println("You solved the memory game after " +(10-guess_chances) + " chances. It took you " + guessing_time + " seconds");
                //Recording the result.
                Result result = new Result(guessing_time,(10-guess_chances), "Easy");
                BestResult bestResult = new BestResult(result);
                System.out.println("Top 10 result: ");
                //Display data.
                bestResult.show();
            }
            // if there are no more guess chances remaining
            else {
                // end the game
                gameOngoing = false;
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
