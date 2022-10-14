package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

/*    public static void oneMonthCalendar(int amountOfDays, int firstDay) {

    }

    public static long[] lcg(long seed) {
        long[] result = new long [10];
        return result;
    }

    public static void guessingGame(int numberToGuess) {

    }

    public static int randomNumberBetweenOneAndHundred() {

    }*/

/*
    public static int[] extendArray(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length+ arrayB.length];

        if(arrayA.length > arrayB.length){
            // start with B
            for (int i = 0; i < arrayB.length; i++) {
                arrayC[i] = arrayB[i];
            }

            for (int i = arrayB.length; i < arrayA.length+ arrayB.length; i++) {
                arrayC[i] = arrayA[i-arrayB.length];
            }
        }

        else if(arrayB.length > arrayA.length) {
            //start with A
            for (int i = 0; i < arrayA.length; i++) {
                arrayC[i] = arrayA[i];
            }

            for (int i = arrayA.length; i < arrayA.length+ arrayB.length; i++) {
                arrayC[i] = arrayA[i-arrayA.length];
            }
        }


        else {
            int counter = 0;
            for (int i = 0; i < arrayA.length; i++) {
                arrayC[counter] = arrayA[i];
                counter++;
                arrayC[i+1] = arrayB[i];
                counter++;
            }

        }

        return arrayC;
    }
*/

/*    public static int generateRandomMonth() {
        return 1;
    }

    public static int monthMapper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between ... or r");

        String userinput = scanner.nextLine();

        if(userinput.equals("r")) {

            }
        else {
        }

        String month = "Invalid month";

        switch (userinput) {
            case "1":
            month = "January";
            case '2':
            month = "February";
        }

    }
    */

    //task 1
    public static void oneMonthCalendar(int amountOfDays, int firstDay) {
        int amountOfWeeks = (int) Math.ceil((double)amountOfDays/7);
        if (firstDay >=2 && amountOfDays==28 || firstDay == 6 && amountOfDays == 31 || firstDay == 7 && amountOfDays >= 30)
            amountOfWeeks++;
        int[][] month = new int[amountOfWeeks][7];

        int day = 1;
        for (int i = 0; i < amountOfWeeks; i++) {
            if(i==0){
                for (int j = 0; j < firstDay-1; j++) {
                    month[i][j] = 0;
                }
                for (int j = firstDay-1; j < 7; j++) {
                    month[i][j] = day;
                    day++;
                }
            }
            else{
                for (int j = 0; j < 7; j++) {
                    if(day > amountOfDays)
                        break;
                    month[i][j] = day;
                    day++;
                }
                if(day > amountOfDays)
                    break;
            }
        }

        for (int i = 0; i < amountOfWeeks; i++) {
            if(firstDay==1){
                if(i==amountOfWeeks-1) {
                for (int j = 0; j < 7; j++) {
                    System.out.printf("%2d", month[i][j]);
                    System.out.print(" ");
                    if(month[i][j]==day-1){
                        break;
                    }
                }
                System.out.println();
                break;
                }
                for (int j = 0; j < 7; j++) {
                    System.out.printf("%2d", month[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            else{
                if(i==0) {
                    for (int j = 0; j < firstDay-1; j++) {
                        System.out.print("   ");
                    }
                    for (int j = firstDay-1; j < 7; j++) {
                        System.out.printf("%2d", month[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                else if(i==amountOfWeeks-1) {
                    for (int j = 0; j < 7; j++) {
                        if(month[i][j]==0)
                            continue;
                        System.out.printf("%2d", month[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                else {
                    for (int j = 0; j < 7; j++) {
                        System.out.printf("%2d", month[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
    }

    //task 2
    public static long[] lcg(long seed) {
        long[] result = new long [10];
        long m = (long) Math.pow(2,31);
        long a = 1103515245;
        long c = 12345;

        result[0] = (long) ((a*seed + c) % m);
        for (int i = 1; i < 10; i++) {
            result[i]= (long) ((a*result[i-1] + c) % m);
        }
        return result;
    }

    public static void showLcg(long[] result) {
        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }
        System.out.println();
    }

    //task 3
    public static void guessingGame (int NumberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int i;
        for (i = 0; i < 10; i++) {
            System.out.print("Guess number " + (i+1) + ": ");
            int num = scanner.nextInt();

            if(i==9 && num != NumberToGuess) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if(num == NumberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            else if(num > NumberToGuess)
                System.out.println("The number AI picked is lower than your guess.");
            else System.out.println("The number AI picked is higher than your guess.");


        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        return (int) (1 + Math.random() * 100);
    }

    //task 4
    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;

        int[] array3 = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array2[i];
        }

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array3[i];
        }

        return true;
    }

    public static int[] fillArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of Array 1: ");
        int length = scanner.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Enter number" + (i+1) + ": ")
            ;array[i] = scanner.nextInt();
        }

        return array;
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.println(" ");
        }
        System.out.println();
    }

    //task 5
    public static String camelCase (String sentence) {
        char[] sentenceChar1 = sentence.toCharArray();
        int count1 = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if ((int) sentenceChar1[i] < 65 || (int) sentenceChar1[i] > 90
                    && (int) sentenceChar1[i] < 97 || (int) sentenceChar1[i] > 122) {
                count1++;
            }
        }

        int length = sentence.length() - count1;
        char[] sentenceChar2 = new char[length];
        int[] sentenceInt = new int[length];
        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if ((int) sentenceChar1[i] < 65 || (int) sentenceChar1[i] > 90
                    && (int) sentenceChar1[i] < 97 || (int) sentenceChar1[i] > 122)
                continue;

            if(i == 0) {
                if ((int) sentenceChar1[i] > 65 && (int) sentenceChar1[i] < 90) {
                    sentenceInt[i] = ((int) sentenceChar1[i]);
                    sentenceChar2[count] = (char) sentenceInt[i];
                }
                if ((int) sentenceChar1[i] >= 97 && (int) sentenceChar1[i] <= 122) {
                    sentenceInt[i] = ((int) sentenceChar1[i]) - 32;
                    sentenceChar2[count] = (char) sentenceInt[i];
                }
                count++;
                continue;
            }

            if((int) sentenceChar1[i-1] == 32 && (int) sentenceChar1[i] >= 65 && (int) sentenceChar1[i] <= 90) {
                sentenceChar2[count] = sentenceChar1[i];
                }
            else if ((int) sentenceChar1[i-1] == 32 && (int) sentenceChar1[i] >= 97 && (int) sentenceChar1[i] <= 122){
                sentenceChar2[count] = (char) ((int) sentenceChar1[i] - 32);
            } else {
                if ((int) sentenceChar1[i] >= 65 && (int) sentenceChar1[i] <= 90) {
                    sentenceChar2[count] = (char) ((int) sentenceChar1[i] + 32);
                }
                if ((int) sentenceChar1[i] >= 97 && (int) sentenceChar1[i] <= 122) {
                    sentenceChar2[count] = sentenceChar1[i];
                }
            }
            count++;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(sentenceChar2);
        return builder.toString();
    }

    public static void main(String[] args) {
        oneMonthCalendar(28,2);

        showLcg(lcg(55));

/*        int randomNumber = randomNumberBetweenOneAndHundred();
        guessingGame(randomNumber);

        int[] array1 = fillArray();
        int[] array2 = fillArray();

        if(swapArrays(array1, array2)) {
            showArray(array1);
            showArray(array2);
        }
        System.out.println("Length of Arrays are not equal!");*/

        String camelCase1  = "Hello my NYme isn't Illia";
        String camelCase2 = new String(camelCase(camelCase1));

        System.out.println(camelCase2);

    }
}