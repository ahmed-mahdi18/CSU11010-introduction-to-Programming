public class TwelveDaysofChritmas {

    public static void main(String[] args) {
        System.out.println(("\n\t=== The Twelve Days of Christmas ===\n"));

        for (int day=1; day<=12; day++) {
            System.out.print("On the ");

            switch(day) {
                case 1:     System.out.print("First" ); break;
                case 2:     System.out.print("Second" ); break;
                case 3:     System.out.print("Third" ); break;
                case 4:     System.out.print("Fourth" ); break;
                case 5:     System.out.print("Fifth" ); break;
                case 6:     System.out.print("Sixth" ); break;
                case 7:     System.out.print("Seventh" ); break;
                case 8:     System.out.print("Eighth" ); break;
                case 9:     System.out.print("Ninth" ); break;
                case 10:    System.out.print("Tenth" ); break;
                case 11:    System.out.print("Eleventh" ); break;
                case 12:    System.out.print("Twelfth" ); break;
                default:


            }
            System.out.println(" Day of Christmas, my True Love gave to Me:");

            switch(day) {
                    case 12:    System.out.println("12 Drummers Drumming," );
                    case 11:    System.out.println("11 Pipers Piping," );
                    case 10:    System.out.println("10 Lords a-Leaping," );
                    case 9:     System.out.println("9 Ladies Dancing," );
                    case 8:     System.out.println("8 Maids a-Milking," );
                    case 7:     System.out.println("7 Swans a-Swimming," );
                    case 6:     System.out.println("6 Geese a-Laying," );
                    case 5:     System.out.println("5 Golden Rings;" );
                    case 4:     System.out.println("4 Calling Birds," );
                    case 3:     System.out.println("3 French Hens," );
                    case 2:     System.out.println("2 Turtle Doves," );
                    default:    System.out.print(day==1 ? "A " : "And a " );
                        System.out.println("Partridge in a Pear Tree.");
                        System.out.println();
            }

        }




    }
}
