/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: my variable names are easy to understand and meaningful
    2. Is my code easy to follow/understand?
       Mark out of 5:   5
       Comment: my code is easy to understand, it is clear and concise
   3. Did I use the functions as required?
       Mark out of 10: 10
       Comment: yes i used the functions correctly as required
       Total Mark out of  20 (Add all the previous marks):
*/


import java.util.Scanner;

public class PerniciousNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        System.out.print("Enter the maximum number you want to consider:");
        int number = input.nextInt();
        for (int i=0; (i <= number); i++) {
            int binaryOnes = countBinaryOnes(i);
            String BinaryString = getBinaryString(i);
            if (isPernicious(i)) {
                System.out.println(i + " is a pernicious number as it contains " + binaryOnes +
                        " ones in it's binary representation " + "(" + BinaryString  + ")");
            }
        }
    }
    public static String getBinaryString(int number) {
        if (number < 0)
        {
            return ("-" + Integer.toBinaryString(Math.abs(number)));
        }
        else
        {
            return Integer.toBinaryString(Math.abs(number));
        }

    }
    public static int countBinaryOnes(int number) {
        return Integer.bitCount(Math.abs(number));
    }
    public static boolean isPrime(int number) {
        if (  number <= 1)
            return false;
        boolean finished = false;
        for (int i = 2; i <=  number  / 2; ++i) {
            if (  number % i == 0) {
                finished = true;
                break;
            }
        }

        return !finished;
    }
    public static boolean isPernicious(int number) {
        boolean isPernicious = false;
        if (isPrime(countBinaryOnes(number))) {
            isPernicious = true;
        }
        return isPernicious;
    }
}
