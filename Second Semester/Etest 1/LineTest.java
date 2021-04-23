public class LineTest {
    public static void main(String[] args) {

        Point point1 = new Point(7, 8);
        Point point2 = new Point(7, 5);
        Line line = new Line(point1, point2);
        System.out.println( toString(line.getP1()));
        System.out.println( toString(line.getP2()));

        Line line2 = new Line(9,11,9,3);
        System.out.println( toString(line2.getP1()) );
        System.out.println( toString(line2.getP2()));
        System.out.printf("the slope is %.2f " ,line2.getSlope());



    }
     public static String toString(Point point) {
        int PointX = point.getX();
        int PointY = point.getY();
        return "(" + PointX + ", " + PointY + ")";
    }

}