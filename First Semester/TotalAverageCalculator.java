/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable and constant names?
       Mark out of 10: 10
       Comment: i used meaningful and understandable  variabale names
   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
       Mark out of 5: 5
       Comment: i formatted the names appropriately
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: my code is indented very well and easy to read
   4. Did I implement a for loop to read the input as required?
       Mark out of 10: 10
       Comment: i implemented a for loop to the program to read in the inputs
      Total Mark out of  35 (Add all the previous marks): 35
*/
import java.util.Scanner;

public class TotalAverageCalculator {

    public static void main(String[] args) {


        System.out.println("How many integers do you want to enter?");
        Scanner input = new Scanner( System.in );
        double amountOfIntegers = input.nextDouble();

        if (amountOfIntegers < 2 || amountOfIntegers > 10  ){
            System.out.println("Error:  This program is constrained to only compute the total & average of between 2 & 10 integers.");
        }
        else  {

            double integerInput = 0;
            double integerSum = 0;
            double integerAverage = 0;

            for ( int count = 1; count <= amountOfIntegers; count++ ) {
                System.out.println("Enter integer"+ " " + count +":" );
                integerInput = input.nextDouble();

                integerSum +=integerInput;
                integerAverage = integerSum/ amountOfIntegers;

            }
            System.out.printf("The sum of your integers is %.0f and the average is %.2f" ,integerSum,integerAverage);


        }


        }


















    }



