public class Line {


    private Point point1;
    private Point point2;



    public Line(Point point1, Point point2) {
        this.point1 = new Point(point1.getX(), point1.getY());
        this.point2 = new Point(point2.getX(), point2.getY());
    }

    public Line( int x1, int y1, int x2, int y2) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    public Point getP1() {
        return this.point1;
    }

    public Point getP2() {
        return this.point2;
    }

    public double getSlope(){
        if (point1.getX() == point2.getX()) {
            throw new ArithmeticException("You cannot divide by 0");
        } else {
        return (((double)point2.getY() - (double)point1.getY()) / (point2.getX() - (double)point1.getX()));
        }

    }


}
