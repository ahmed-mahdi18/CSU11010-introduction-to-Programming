/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5: 5
       Comment: my variable names are understandable and meaningful
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: my variable names are in the correct form which is lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: my code is indented very well and it is clear to understand what is what
   4. Did I implement a switch statement as required?
       Mark out of 10: 10
       Comment: i have used a switch statement as required
       Total Mark out of  25 (Add all the previous marks): 25
*/
import java.util.Scanner;

public class Prizes {
    public static void main(String[] args) {

        boolean finished = false;

        System.out.println("This program tells competition participants what prize they have won.");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your place number (or type 'exit'): ");

        do {
                for ( int userNumber = 1; userNumber <= 10; userNumber++) {
                    if (input.hasNextInt()) {
                    userNumber = input.nextInt();

                   if (userNumber <=0 || userNumber > 10){
                        System.out.println("Sorry.  You did not win a prize." + "\nEnter your place number (or type 'exit'):");
                        break;
                   }
                    System.out.print("You came in " + userNumber);
                        switch (userNumber) {
                            case 1:
                                System.out.print("st");
                                break;
                            case 2:
                                System.out.print("nd");
                                break;
                            case 3:
                                System.out.print("rd");
                                break;
                            default:
                                System.out.print("th");
                                break;
                        }
                        System.out.print(" place and hence won");

                        switch (userNumber) {
                        case 1:
                            System.out.print(" two theatre tickets + drinks during the interval + dinner before the show.");
                            System.out.println("\nEnter your place number (or type 'exit'): ");
                            break;
                        case 2:
                            System.out.print(" two theatre tickets + drinks during the interval.");
                            System.out.println("\nEnter your place number (or type 'exit'): ");
                            break;
                        case 3:
                            System.out.print(" two theatre tickets.");
                            System.out.println("\nEnter your place number (or type 'exit'): ");
                            break;
                        case 4:
                        case 5:
                            System.out.print(" a 10 Euro book token.");
                            System.out.println("\nEnter your place number (or type 'exit'): ");
                            break;
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            System.out.print(" a 5 Euro book token.");
                            System.out.println("\nEnter your place number (or type 'exit'): ");
                            break;
                        default:
                            System.out.println("Sorry.  You did not win a prize." + "\nEnter your place number (or type 'exit'):");

                    }
                }
            }
                if (input.hasNext("exit")) {
                    finished = true;
                    break;
                }

            } while (true);
            input.close();
        }
    }


































