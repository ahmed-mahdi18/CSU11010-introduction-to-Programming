import java.util.Scanner;

public class LoanRepaymentCalculator {

    public static void main(String[] args) {
        System.out.println("Enter loan amount?");
        Scanner input = new Scanner( System.in );
        double loanAmount = input.nextDouble();

        System.out.println("Enter annual interest rate (e.g. 0.04)?");
        input.useDelimiter("(\\p{javaWhitespace}|\\:)+");
        double annualInterest = input.nextDouble();

        System.out.println("Enter the term of the loan in years?");
        double loanYears = input.nextDouble();

        input.close();

        final int MONTHS_IN_A_YEAR = 12;
        double monthlyInterest = annualInterest / MONTHS_IN_A_YEAR;
        double amountOfMonths = loanYears * MONTHS_IN_A_YEAR;

        double calculationOne = Math.pow((1+monthlyInterest), amountOfMonths);  //calculating (1+r)^n therefore calling it rate1
        double calculationTwo = (monthlyInterest * calculationOne) / (calculationOne - 1);        //calculating r * (1+r)^n / (1+r)^n - 1

        double monthlyRepayment = (loanAmount * calculationTwo);

        System.out.printf("The monthly repayment for a %.0f year loan of %.2f at an annual interest rate of %.2f would be %.2f",
                loanYears, loanAmount, annualInterest, monthlyRepayment );





    }






}
