import java.util.Scanner;

public class factorianNumberstutorialQ {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        System.out.print("Enter your factorial number or enter (quit):");
        do {
            while (input.hasNextInt()) {
                int factorialNumber = input.nextInt();
                if (isFactorian(factorialNumber))
                    System.out.println("the number is factorial");
                else
                    System.out.println("the number is not factorial");
                System.out.print("Enter your factorial number or enter (quit):");
            }
            if (input.hasNext("quit")) {
                finished = true;
                System.out.println("Goodbye.");
            } else {
                System.out.println("Error:  You must enter a real number" + "\nEnter your factorial number or enter (quit):");
                input.next();
            }
        } while (!finished);
        input.close();
    }


    public static int computeFactorial (int factorialNumber) {
        int fact = 1;
        while ( factorialNumber != 0) {
            fact = fact * factorialNumber;
            factorialNumber--;
        }
        return fact;

    }

    public static boolean isFactorian (int factorialNumber) {
        int sum = 0;

        
        int temp = factorialNumber ;
        while (temp != 0) {
            sum += computeFactorial(temp % 10);
            temp = temp / 10;
        }

        return (sum == factorialNumber);


    }
}
