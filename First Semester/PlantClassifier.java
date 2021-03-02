import java.util.Scanner;

public class PlantClassifier {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Does the plant have cells and tissues which are organised into functional structures (Yes/No)?  ");
        String cellStructureAnswer = input.next();
        boolean cellStructure = cellStructureAnswer.equalsIgnoreCase("Yes");
        if (!cellStructure) {
            System.out.println("The plant is an ALGAE.");
        }

        if (cellStructure) {
            System.out.println("Does the plant have vascular tissues (Yes/No)?");
            String vascularTissuesAnswer = input.next();
            boolean vascularTissues = vascularTissuesAnswer.equalsIgnoreCase("Yes");
            if (!vascularTissues) {
                System.out.println("The plant is a BRYOPHYTE.");
            }

            if (vascularTissues) {
                System.out.println("Is the plant dispersed by seeds (Yes/No)?");
                String dispersedBySeedsAnswer = input.next();
                boolean dispersedBySeeds = dispersedBySeedsAnswer.equalsIgnoreCase("Yes");
                if (!dispersedBySeeds) {
                    System.out.println("The plant is a PTERIDOPHYTE.");

                } else {
                    System.out.println("Are the seeds enclosed (Yes/No)?");
                    String seedsEnclosedAnswer = input.next();
                    boolean seedsEnclosed = seedsEnclosedAnswer.equalsIgnoreCase("Yes");

                    if (!seedsEnclosed)
                        System.out.println("The plant is a GYMNOSPERM.");
                    else System.out.println("The plant is an ANGIOSPERM.");


                }
            }


        }


    }

}











