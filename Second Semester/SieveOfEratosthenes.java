
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




