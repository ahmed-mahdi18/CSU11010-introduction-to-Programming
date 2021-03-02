
import java.util.Scanner;

public class ChuckALuckDiceGame {
    public static void main(String[] args) {
        double originalCash = 0;
        boolean inputCorrectCash = false;
        boolean finished = false;
        Scanner input = new Scanner(System.in);
        Wallet wallet = new Wallet();
        while (!inputCorrectCash) {
            System.out.print("Please enter the amount of cash you have:");
            if (input.hasNextDouble()) {
                originalCash = input.nextDouble();
                wallet.put(originalCash);
                if (originalCash > 0) {
                    inputCorrectCash = true;
                    finished = false;
                }
                System.out.println("Your wallet holds: €" + wallet.check());

            } else if (!input.hasNextDouble()) {
                System.out.println("Error:  You must enter a real number");
                input.next();

            }
            if (originalCash <= 0) {
                finished = true;
                System.out.print("You have no money to play this game.\n");
            }
        }
        while (!finished) {
            System.out.println("Please enter the bet you would like to make.\nEnter either 'Triple','Field'.'High','Low' or 'Quit: ");
            String userInput = input.next();
            switch (userInput) {
                case "Triple", "triple" -> resolveBet("Triple", wallet);
                case "Field", "field" -> resolveBet("Field", wallet);
                case "High", "high" -> resolveBet("High", wallet);
                case "Low", "low" -> resolveBet("Low", wallet);
                case "Quit", "quit" -> {
                    finished = true;
                    System.out.println("You started with €" + String.format("%.2f", originalCash) + " and now you have €" + String.format("%.2f", wallet.check()));
                    System.out.print("Goodbye.");
                }
                default -> System.out.println("Invalid Input. Please enter correct input");
            }
            if (wallet.check() == 0) {
                finished = true;
                System.out.println("You started with €" + String.format("%.2f", originalCash) + " and you "
                        + "now have €" + String.format("%.2f", wallet.check()));
                System.out.println("You have no more money, goodbye");

            }
        }
    }


    public static void resolveBet(String betType, Wallet wallet) {
        Scanner Input = new Scanner(System.in);
        while (true) {
            System.out.println("Your wallet contains: €" + wallet.check());
            System.out.println("How much money would you like to bet?");
            if (Input.hasNextDouble()) {
                double moneyBetted = Input.nextDouble();
                if (wallet.get(moneyBetted)) {
                    System.out.println("Betting €" + (moneyBetted) + " on " + betType + ".");
                    Dice dice1 = new Dice(6);
                    Dice dice2 = new Dice(6);
                    Dice dice3 = new Dice(6);
                    dice1.roll();
                    dice2.roll();
                    dice3.roll();
                    int total = dice1.topFace() + dice2.topFace() + dice3.topFace();
                    System.out.println("\nDice One = " + dice1.topFace()
                            + "\nDice Two = " + dice2.topFace()
                            + "\nDice Three = " + dice3.topFace()
                            + "\nTotal:" + total + "\n");
                    boolean tripleBet = false;
                    boolean fieldBet = false;
                    boolean highBet = false;
                    boolean lowBet = false;

                    if ((dice1.topFace() == dice2.topFace()) && (dice2.topFace() == dice3.topFace())) {
                        tripleBet = (total != 8) && (total != 3);
                    }
                    if (((total < 8) || (total > 12))) {
                        fieldBet = true;
                    }
                    if ((total > 10) && (total != 12 && total != 15 && total != 18)) {
                        highBet = true;
                    }
                    if ((total < 11) && (total != 3 && total != 6 && total != 9)) {
                        lowBet = true;
                    }
                    switch (betType) {
                        case "Triple":
                            if (tripleBet) {
                                System.out.println("well done, you won your bet on triple!");
                                wallet.put((moneyBetted * 30) + moneyBetted);
                                System.out.println("\nYou won €" + String.format("%.2f", moneyBetted * 30));
                            } else {
                                System.out.print("sorry, You lost your bet on triple!");
                            }
                            break;
                        case "Field":
                            if (fieldBet) {
                                System.out.println("well done, you won your bet on field!");
                                wallet.put(moneyBetted + moneyBetted);
                                System.out.println("You won €" + String.format("%.2f", moneyBetted));
                            } else {
                                System.out.print("sorry, You lost your bet on field!");

                            }
                            break;
                        case "High":
                            if (highBet) {
                                System.out.println("well done, you won your bet on high!");
                                wallet.put(moneyBetted + moneyBetted);
                                System.out.println("You won €" + String.format("%.2f", moneyBetted));
                            } else {
                                System.out.print("sorry, You lost your bet on high!");

                            }
                            break;
                        case "Low":
                            if (lowBet) {
                                System.out.println("well done, you won your bet on low!");
                                wallet.put(moneyBetted + moneyBetted);
                                System.out.println("You won €" + String.format("%.2f", moneyBetted));
                            } else {
                                System.out.print("sorry, You lost your bet on low!");

                            }
                            break;
                        default:
                            break;
                    }
                    System.out.println("\nyou currently have €"
                            + String.format("%.2f", wallet.check()));
                    return;
                } else {
                    System.out.println("you don't have enough money to make this bet.");
                    Input.nextLine();
                }
            } else {
                System.out.println("Incorrect input");
                Input.nextLine();

            }
        }
    }
}














