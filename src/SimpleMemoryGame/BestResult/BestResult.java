package SimpleMemoryGame.BestResult;

import java.io.*;
import java.util.*;

public class BestResult {
    // Path to file.
    private final File file = new File("BestResult.txt");

    // Number of items to display.
    final private int numsForTop = 10;

    private Result[] resArray = new Result[numsForTop];

    //Adding new data.

    private void addResult(Result result) throws IOException {
        if (result != null && result.getName() != null && !result.getName().isEmpty()) {
            try (FileWriter fileWriter = new FileWriter(file, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(result.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
    }

    //Deleting not sorted data and writing sorted data.
    private void updateData() throws IOException {
        sort();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(""); // Clear the file
            for (int i = 0; i < numsForTop; i++) {
                addResult(resArray[i]);
            }
        }
    }

    //Reading data.
    private void readTop() throws Exception {
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String[] temps = new String[numsForTop];
            int i = 0;
            while (bufferedReader.ready()) {
                temps[i] = bufferedReader.readLine();
                i++;
            }
            String[][] items = new String[numsForTop][5];

            // Initialize all the elements of resArray if they are null
            for (int j = 0; j < numsForTop; j++) {
                if (resArray[j] == null) {
                    resArray[j] = new Result();
                }
            }

            // Process all the elements of temps
            for (int j = 0; j < numsForTop && temps[j] != null; j++) {
                items[j] = temps[j].split(" \\| ");

                resArray[j].setName(items[j][0].strip());
                resArray[j].setGuessing_date(items[j][1].strip());
                resArray[j].setGuessing_time(Double.parseDouble(items[j][2].strip()));
                resArray[j].setGuessing_tries(Integer.parseInt(items[j][3].strip()));
                resArray[j].setMode(items[j][4].strip());
            }
        }
    }

    private boolean comparison(double guessing_tries) {
        return guessing_tries < resArray[numsForTop - 1].getGuessing_tries();
    }

    //Sorting algorithm.
    private void sort() {
        for (int i = resArray.length - 1; i > 0; i--) {
            if (!resArray[i].isEmpty()) {
                sort(0, i);
                break;
            }
        }
    }

    private void sort(int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = new Random().nextInt(high - low) + low;
        swapResult(pivotIndex, high);
        int pivot = resArray[high].getGuessing_tries();

        int leftPointer = partition(low, high, pivot);

        sort(low, leftPointer - 1);
        sort(leftPointer + 1, high);

    }

    private int partition(int low, int high, int pivot) {
        int leftPointer = low;
        int rightPointer = high;

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && resArray[leftPointer].getGuessing_tries() <= pivot) {
                leftPointer++;
            }

            while (leftPointer < rightPointer && resArray[rightPointer].getGuessing_tries() >= pivot) {
                rightPointer--;
            }

            swapResult(leftPointer, rightPointer);
        }

        swapResult(leftPointer, high);
        return leftPointer;
    }

    //Changing the display sequence.
    private void swapResult(int index1, int index2) {
        if (index1 >= 0 && index1 < resArray.length && index2 >= 0 && index2 < resArray.length) {
            Result temp = resArray[index1];
            resArray[index1] = resArray[index2];
            resArray[index2] = temp;
        }
    }

    //Display data.
    public void show() throws Exception {
        readTop();
        System.out.printf("%-3s%-20s%-15s%-25s%-15s%-15s%n", "#", "Name", "Date", "Guessing_Time", "Guessing_Tries", "Mode");
        for (int i = 0, j = 1; i < numsForTop; i++) {
            if (resArray[i] != null && !resArray[i].isEmpty()) {
                System.out.printf("%-3s", j + ".");
                System.out.printf("%-20s%-15s%-25s%-15s%-15s%n", resArray[i].getName(), resArray[i].getGuessing_date(),
                        resArray[i].getGuessing_time(), resArray[i].getGuessing_tries(), resArray[i].getMode());
                j++;
            }else{
                break;
            }
        }
    }

    public BestResult(Result result) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }

        if (file.length() == 0) {
            addResult(result);
        } else {
            readTop();
            if (resArray[numsForTop - 1].isEmpty()) {
                addResult(result);
                readTop();
                updateData();

            } else {
                if (comparison(result.getGuessing_tries())) {
                    resArray[numsForTop - 1].setName(result.getName());
                    resArray[numsForTop - 1].setGuessing_date(result.getGuessing_date());
                    resArray[numsForTop - 1].setGuessing_time(result.getGuessing_time());
                    resArray[numsForTop - 1].setGuessing_tries(result.getGuessing_tries());
                    resArray[numsForTop - 1].setMode(result.getMode());
                    updateData();
                }

            }

        }
    }

    public BestResult() {

    }
}