import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the first number  ");
        double No1 = scanner.nextDouble();

        System.out.println("Insert the second number  ");
        double No2 = scanner.nextDouble();

        System.out.println("Insert the third number  ");
        double No3 = scanner.nextDouble();

        scanner.close();


        double Average = (No1 + No2 + No3)	/ 3	;
        double roundOff = (double) Math.round(Average * 100) / 100;

        double Standarddeviation1 = (No1 + No2 + No3 - Average);
        double Standarddeviation2 = Math.pow(Standarddeviation1 , 2) / 3;
        double MyNumber = Math.sqrt(Standarddeviation2);
        double roundOff2 = (double) Math.round(MyNumber * 100) / 100;


        System.out.println("the Average is " + roundOff);
        System.out.println("the Standard deviation is " + roundOff2);




    }

}


