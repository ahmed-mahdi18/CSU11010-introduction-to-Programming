/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:  5
       Comment: my variable names are understandable and meaningful
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: all my variable names are witten in lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: my code is indented perfectly and its clear and concise
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10:   10
       Comment: i have a do-while loop in my program
      Total Mark out of  25 (Add all the previous marks): 25
*/
import java.util.Scanner;

public class IncrementalStatistics {

    public static void main(String[] args) {
        double sum = 0;
        double numberCount = 0;
        double previousAverage = 0;
        double newAverage = 0;
        double previousVariance = 0;
        double newVariance = 0;
        boolean finished = false;
        System.out.println("This program computes the average and variance of all numbers entered.");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (or type 'exit'):");
        do {
            while (input.hasNextDouble())
            {
                double number = input.nextDouble();
                {
                    numberCount++;
                    newAverage = previousAverage + ((number - previousAverage) / numberCount);
                    newVariance =(( numberCount - 1) * previousVariance + (number - previousAverage) * (number - newAverage)) / numberCount;

                    System.out.printf("So far the average is %.1f and the variance is %.1f ", newAverage, newVariance);
                    System.out.println("\nEnter another number (or type 'exit'): ");

                    previousVariance = newVariance;
                    previousAverage = newAverage;
            }
        }
        if  (input.hasNext("exit") || input.hasNext("quit"))
        {
            finished = true;
            System.out.println("Goodbye.");
        }
        else
        {
            System.out.println("Error:  You must enter a real number (e.g. 12.5)" + "\nEnter another number (or type 'exit'): ");
            input.next();
        }
        } while (!finished);
            input.close();
    }
}








































