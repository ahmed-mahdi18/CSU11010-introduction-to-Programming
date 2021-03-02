import java.util.Scanner;

public class MultiplesTutorialQ {

    public static void main(String[] args) {

        int multipleBase;
        int multipleMax;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Multiples of what? ");
        multipleBase = scanner.nextInt();

        System.out.print("Up to a maximum of ? ");
        multipleMax = scanner.nextInt();
        scanner.close();
        StringBuilder template = new StringBuilder(String.format("The multiples of %d (up to %d) are ", multipleBase, multipleMax));

        int i = 0;
        for (; i <= multipleMax-multipleBase; i+=multipleBase) {
            template.append(i)
                    .append(", ");
        }

        System.out.println(template.append(i + "."));

    }
}
