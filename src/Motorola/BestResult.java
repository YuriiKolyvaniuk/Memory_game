package Motorola;

import java.io.*;
import java.util.*;

public class BestResult{
    ////////////////////Path to file.////////////////////
    File file = new File("BestResult.txt");
    ////////////////////Number of items to display.////////////////////
    private int numsFor_top = 10;

    ////////////////////Just arrays for data.////////////////////
    String[] names = new String[numsFor_top];
    String[] dates = new String[numsFor_top];
    double[] times = new double[numsFor_top];
    int[] tries = new int[numsFor_top];
    String[] modes = new String[numsFor_top];

    ////////////////////Checking if the file is empty.////////////////////
    private boolean isFileEmpty(File input){
        return input.length() == 0;
    }
    ////////////////////Checking if the file exists.////////////////////
    private void start() throws Exception{
        if(file.exists()){
            file.createNewFile();
        }
    }
    ////////////////////Adding new data.////////////////////
    private void addResult(String name, String date, double guessing_time, int guessing_tries, String mode) throws IOException {
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(name + " | " + date + " | " + guessing_time + " | " + guessing_tries + " | "+ mode + " | ");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    ////////////////////Deleting data and writing new ones.////////////////////
    private void updateData() throws IOException {
        new FileWriter(file,false).close();
        for(int i =0;i < numsFor_top;i++){
            addResult(names[i],dates[i],times[i],tries[i],modes[i]);
        }
    }
    ////////////////////Reading data.////////////////////
    private void readTop() throws Exception {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\|");
        scanner.useLocale(Locale.US);
        int i = 0;
        while(scanner.hasNext()){
            names[i] = scanner.next();
            dates[i] = scanner.next();
            times[i] = scanner.nextDouble();
            tries[i] = scanner.nextInt();
            modes[i] = scanner.next();
            i++;
        }
    }

    private boolean comparison(double guessing_time){
        return guessing_time < tries[numsFor_top-1];
    }
    ////////////////////Sorting algorithm.////////////////////
    private void sort(){
        sort(0,tries.length-1);
    }
    private void sort(int low, int high){
        if(low >= high){
            return;
        }

        int pivotIndex = new Random().nextInt(high-low)+low;
        int pivot = tries[pivotIndex];
        swap(pivotIndex,high);

        int leftPointer = partition(low, high, pivot);

        sort(low,leftPointer-1);
        sort(leftPointer+1,high);

    }
    private int partition(int low, int high, int pivot) {
        int leftPointer = low;
        int rightPointer = high;

        while(leftPointer < rightPointer){
            while(tries[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while(tries[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(leftPointer,rightPointer);
        }

        swap(leftPointer, high);
        return leftPointer;
    }

    ////////////////////Changing the display sequence.////////////////////
    private void swap( int index1, int index2){
        int tempTry = tries[index1];
        tries[index1] = tries[index2];
        tries[index2] = tempTry;

        double tempTime = times[index1];
        times[index1] = times[index2];
        times[index2] = tempTime;

        String tempName = names[index1];
        names[index1] = names[index2];
        names[index2] = tempName;

        String tempDate = dates[index1];
        dates[index1] = dates[index2];
        dates[index2] = tempDate;

        String tempMode = modes[index1];
        modes[index1] = modes[index2];
        modes[index2] = tempMode;

    }

    ////////////////////Display data.////////////////////
    public void show() {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10%s", "#", "Name", "Date", "Guessing Time", "Guessing Tries","Mode");
        for (int i = numsFor_top-1; i >= 0; i++) {
            if (dates[i] != null) {
                System.out.printf("%-10d", i + 1);
                System.out.println(". ");
                System.out.printf("%-15s%-15s%-15f%-15d%-15s", names[i], dates[i], times[i], tries[i], modes[i]);
            }
        }
    }

    BestResult(String name, String date, double guessing_time, int guessing_tries, String mode) throws Exception{
        start();
        if(isFileEmpty(file)){
            addResult(name,date,guessing_time,guessing_tries,mode);
        }else{
            readTop();
            if(names[numsFor_top-1] == null){
                addResult(name,date,guessing_time,guessing_tries,mode);
                readTop();
                sort();
                updateData();

            }else{
                if(comparison(guessing_tries)){
                    names[numsFor_top-1] = name;
                    dates[numsFor_top-1] = date;
                    times[numsFor_top-1] = guessing_time;
                    tries[numsFor_top-1] = guessing_tries;
                    modes[numsFor_top-1] = mode;
                    sort();
                    updateData();
                }

            }

        }
    }
    BestResult(){

    }
}