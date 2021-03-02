/* SELF ASSESSMENT
   1.    createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: the method definiton is correct
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: N is passed as a parmaeter and initialised
Did I return the correct item?
Mark out of 5: 5
Comment: the correct item primeNumbers is returned
   2.    crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 0
Comment:
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: i made sure the parameters are not null
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: the correct multiple is being used to loop through the method
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: they are crossed out as the program progresses
   3.    sieve
Did I have the correct function definition?
Mark out of 5: 5
Comment: i used the correct method definition
Did I make calls to other methods?
Mark out of 5: 5
Comment: yes i made calls t create sequence and crossoutHigherMultiples methods
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: yes i have
   4.    sequenceTostring
Did I have the correct function definition?
Mark out of 5: 5
Comment: yes i have used the correct method definition
Did I ensure the parameter to be used is not null?
Mark out of 3: 0
Comment:
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets?
Mark out of 10: 10
Comment: yes i have
   5.    nonCrossedOutSubseqToString
Did I have the correct function definition
Mark out of 5: 5
Comment: i used the correct method definition
Did I ensure the parameter to be used is not null?
Mark out of 3: 0
Comment:
Did I loop through the array updating the String variable with just the non-crossed out numbers?
Mark out of 5: 5
Comment: yes the string is updated with non-crossed out numbers
   6.    main
Did I ask  the user for input n and handles input errors?
Mark out of 5: 5
Comments: yes i have
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: yes
Did I print the output as shown in the question?
Mark out of 5: 5
Comment: yes
   7.    Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: my code is indented properly
Do my variable names make sense?
Mark out of 4: 4
Comments: my variable names are meaningful
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: yes they do
      Total Mark out of 100 (Add all the previous marks): 89
*/



import java.util.Scanner;


public class SieveOfEratosthenes {

    public static void main(String[] args) {

        System.out.println("Enter a number >= 2: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number < 2) {
            System.out.println("please enter a number greater than 2 ");
        } else {
        int[] numbers = sieve(number);
        System.out.print(nonCrossedOutSubseqToString(numbers));
        }

    }

    public static int[] createSequence(int N) {
           int array = 0;
           int[] primeNumbers = new int[N - 1];
           for (int index = 2; index <= N; index++) {
               primeNumbers[array] = index;
               array++;
           }
           return primeNumbers;


    }

    public static int[] crossOutHigherMultiples(int[] array, int multiple) {
        int[] array1 = array.clone();
        int number;
        int array2 = 0;
        int array3 = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] != 0) {
                number = array[index];
                if (number / multiple != 1 && number % multiple == 0) {
                    array[index] = 0;
                }
            }
            if (index + 1 == array.length) {
                int resultArray = 0;
                while ((resultArray < array.length) && (array2 == array3)) {
                    array2 = array[resultArray];
                    array3 = array1[resultArray];
                    resultArray++;
                    if (array3 != array2) {
                        System.out.println(sequenceToString(array));
                    }
                }

                
                array1 = array.clone();
            }
        }
        return array;

    }
    public static int[] sieve(int N) {
        int[] ints = {};
        if (N != 0) {
            int[] array = createSequence(N);
            System.out.println(sequenceToString(array));
            int[] arraySieve = array.clone();
            for (int index = 2; index <= N; index++) {
                ints = crossOutHigherMultiples(arraySieve, index);

            }
            return ints;

        }
        return new int[0];
    }
    public static String sequenceToString(int[] sieveArray) {
        StringBuilder stringArray = new StringBuilder();
        stringArray.append(2);
        for (int index =1; index< sieveArray.length;index++) {
            if(sieveArray[index] == 0) {
                stringArray.append(", [").append(sieveArray[index]).append("]");

            } else {
                stringArray.append(", ").append(sieveArray[index]);
            }
        }
        return stringArray.toString();

    }

    public static String nonCrossedOutSubseqToString(int[] sieveArray) {
        StringBuilder stringArray = new StringBuilder();
        stringArray.append(2);
        for (int index = 1; index < sieveArray.length; index++) {
            if (sieveArray[index] != 0) {
                stringArray.append(", ").append(sieveArray[index]);
            }

        }
        return stringArray.toString();
    }

}




