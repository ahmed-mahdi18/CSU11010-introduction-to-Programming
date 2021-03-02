import java.util.Scanner;
public class GradeComputation {
    public static final String[] MODULE_CODES = {"CSU11001", "CSU11010", "CSU11013", "CSU11021",
            "CSU11022", "CSU11026", "CSU11031", "CSU11081", "CSU12002", "STU11002"};
    public static final int[] MODULE_CREDITS = {5, 10, 5, 5, 5, 10, 5, 5, 5, 5};

    public static void main(String[] args) {
        boolean finished = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the first year grade assessor.");
        while (!finished) {
            double[] marks = new double[0];
            int index = 0;
            while (index < MODULE_CODES.length && !finished) {
                System.out.println("Enter the student mark for " + MODULE_CODES[index] + " (or enter quit): ");

                if (input.hasNextDouble()) {
                    double[] tempMarks = new double[marks.length + 1];
                    System.arraycopy(marks, 0, tempMarks, 0, marks.length);
                    marks = tempMarks;
                    marks[index++] = input.nextDouble();

                } else if (input.hasNext("quit")) {
                    finished = true;
                } else {
                    System.out.print("Error - Enter a number between 0.0 and 100.0 or quit.\n");
                    input.next();
                }
            }
            if (!finished) {
                int averageMark = (int) Math.round(weightedAverageMark(marks));
                System.out.println("Result = " + determineOverallGrade(marks) + " with an overall mark of " +
                        String.format("%d", averageMark) + "%." + "\n" + " " + (determineOverallGrade(marks).equals("FAIL")
                        ? creditsBelowSpecifiedMark(marks, 40) + " credits were failed." : ""));
                System.out.println();
            }
        }
    }


    public static int creditsBelowSpecifiedMark(double[] marks, int specifiedMinimumMark) {
        int credits = 0;
        for (int index = 0; index < marks.length; index++) {
            if (Math.round(marks[index]) < specifiedMinimumMark) {
                credits = credits + MODULE_CREDITS[index];
            }
        }
        return Math.round(credits);
    }

    public static double weightedAverageMark(double[] marks) {
        double creditsTotal = 0;
        double markTotal = 0;
        for (int moduleCredits : MODULE_CREDITS) {
            creditsTotal = creditsTotal + moduleCredits;
        }
        for (int index = 0; index < marks.length; index++) {
            markTotal = markTotal + marks[index] * (MODULE_CREDITS[index]);
        }
        return (markTotal / creditsTotal);
    }

    public static String determineOverallGrade(double[] marks) {
        double totalMarks = Math.round(weightedAverageMark(marks));
        String stringGrade = " ";
        boolean failed = false;
        int creditFailed = creditsBelowSpecifiedMark(marks, 40);
        for (int index = 0; index < marks.length && !failed; index++) {
            if (Math.round(marks[index]) < 35) {
                failed = true;
            }
            if (creditFailed <= 10 && totalMarks >= 40) {
                if (totalMarks >= 70) {
                    stringGrade = "I";
                } else if (totalMarks >= 60) {
                    stringGrade = "II.1";
                } else if (totalMarks >= 50) {
                    stringGrade = "II.2";
                } else if (totalMarks >= 40) {
                    stringGrade = "III";
                }
            } else {
                stringGrade = "FAIL";
            }
        }
        if (failed)
            stringGrade = "FAIL";
        return stringGrade;
    }
}













