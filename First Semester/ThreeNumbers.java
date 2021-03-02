/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:  5
       Comment: my variable names are easy to understand and meaningful
    2. Did I indent the code appropriately?
       Mark out of 5:  5
       Comment: my code is indented perfectly and it is easy to see where everything is
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10:  10
       Comment: yes i used functions withing main and outside main appropriately
       Total Mark out of  20 (Add all the previous marks): 20
*/

import java.util.Scanner;

public class ThreeNumbers {
    public static final double AMOUNT_OF_NUMBERS = 3.0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("(\\p{javaWhitespace})");
        boolean finished = false;
        do
            {
            System.out.print("Please enter your three integers separated by spaces (or enter 'quit'): ");
            if (input.hasNextInt())
            {
                int numberOne = input.nextInt();
                int numberTwo = input.nextInt();
                int numberThree = input.nextInt();
                int median = medianOf(numberOne, numberTwo, numberThree);
                int valuesGreaterThanAvg = countOfNumbersGreaterThanTheAverage(numberOne, numberTwo, numberThree);
                System.out.println(getFormattedOutputString(median, valuesGreaterThanAvg));

            } else if (input.hasNext("quit"))
            {
                finished = true;
            }
            else {
                input.next();
            }
        } while (!finished);
            input.close();
    }

    public static String getFormattedOutputString(int median, int countOfNumbersGreaterThanTheAverage) {
        if (countOfNumbersGreaterThanTheAverage <= 1)
        {
            return ("The median of your numbers is " + median + ", and " +
                    countOfNumbersGreaterThanTheAverage + " of them is greater than their average.");
        }
        else
        {
            return ("The median of your numbers is " + median + ", and " +
                    countOfNumbersGreaterThanTheAverage + " of them are greater than their average.");
        }
    }

    public static int medianOf(int numberOne, int numberTwo, int numberThree) {
        if (numberOne <= numberTwo) {
            if (numberTwo <= numberThree) {
                return numberTwo;
            } else if (numberOne <= numberThree) {
                return numberThree;
            } else {
                return numberOne;
            }
        } else {
            if (numberOne <= numberThree) {
                return numberOne;
            } else if (numberTwo <= numberThree) {
                return numberThree;
            } else {
                return numberTwo;
            }
        }
    }
    public static double averageOf(double numberOne, double numberTwo, double numberThree) {
        double integerSum = numberOne + numberTwo + numberThree;
        return integerSum / 3.0;
    }
    public static int countOfNumbersGreaterThanTheAverage(int numberOne, int numberTwo, int numberThree) {
        int result = 0;
        double average = averageOf(numberOne, numberTwo, numberThree);
        if (numberOne > average) {
            result++;
        }
        if (numberTwo > average) {
            result++;
        }
        if (numberThree > average) {
            result++;
        }
        return result;
    }

}


