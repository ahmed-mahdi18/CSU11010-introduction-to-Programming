import java.util.Arrays;
import java.util.Scanner;
public class Median {
    public static void main(String[] args) {
        System.out.print("Welcome to the median & rolling average system.\n");
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        double[] array = {};
        int Numbers = 3;
        do {
            System.out.print("Enter a number (or enter quit): ");
            if (input.hasNextDouble()) {
                double[] tempArray = new double[(int)(array.length + 1)];
                System.arraycopy(array,0, tempArray,0, array.length);
                tempArray[(tempArray.length - 1)] = input.nextDouble();
                array = tempArray;
                double rollingAverage = computeRollingAverage(array,Numbers);
                String stringArray = convertToString(array);
                double median = computeMedian(array);
                System.out.printf("The median of %s is %.1f and the rolling average of the last %d values is %.1f.\n"
                        ,stringArray, median, Numbers, rollingAverage);
            }
            else if (input.hasNext("quit"))
            {
                finished = true;
            }
            else {
                System.out.print("Error - Enter any real number or quit.\n");
                input.next();
            }
        } while (!finished);
        input.close();
    }
    public static double computeMedian(double[] arrayNotSorted) {
        double median1;
        double median2;
        double median;
        if (arrayNotSorted == null) {
            return 0;
        } else {
            double[] sortedArray = createSortedArray(arrayNotSorted);
            if (sortedArray.length % 2 == 0) {
                median1 = ( sortedArray[sortedArray.length / 2]);
                median2 = (sortedArray[sortedArray.length / 2 - 1]);
                median = (median1 + median2) / 2;
            } else {
                median = sortedArray[sortedArray.length / 2];

            }
            return median;
        }
    }
    public static double[] createSortedArray ( double[] array){
        if (array == null) {
            return null;
        }else {
            double[] sortedArray = Arrays.copyOf(array, array.length);
            Arrays.sort(sortedArray);
            return sortedArray;
        }
    }
    public static double computeRollingAverage ( double[] array, int Numbers){
        if (array == null) {
            return 0;
        } else {
            double rollingAverage = 0;
            double arrayTotal = 0;
            int count;
            if (Numbers == 0) {
                return 0;
            } else if (array.length <= Numbers) {
                for (count = 0; count < array.length; count++) {
                    arrayTotal = arrayTotal + array[count];
                }
                rollingAverage = arrayTotal / array.length;
            } else {
                for (count = (array.length - Numbers); count < array.length; count++) {
                    arrayTotal = arrayTotal + array[count];
                }
                rollingAverage = (arrayTotal / Numbers);
            }
            return rollingAverage;
        }
    }
    public static String convertToString ( double[] array){
        StringBuilder stringArray = new StringBuilder(("{ "));
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                stringArray.append(String.format("%.1f", array[i]));
                if ((array.length > 1) && (array.length - i !=1)) {
                    stringArray.append(", ");
                }
            }
            stringArray.append(" }");
            return stringArray.toString();
        } else {
            return "{ }";
        }
    }
}
