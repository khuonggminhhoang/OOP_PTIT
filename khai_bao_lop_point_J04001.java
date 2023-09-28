import java.util.Scanner;

class Point{
    private double x, y;

    public Point(){}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point secondPoint){
        return Math.sqrt((this.x - secondPoint.x) * (this.x - secondPoint.x) + (this.y - secondPoint.y)* (this.y - secondPoint.y));
    }

    static double distance(Point p1, Point p2){
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    @Override
    public String toString(){
        return "";
    }
}

public class khai_bao_lop_point_J04001 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            Point p1 = new Point(scn.nextDouble(), scn.nextDouble());
            Point p2 = new Point(scn.nextDouble(), scn.nextDouble());
            System.out.println(String.format("%.4f", Point.distance(p1, p2)));
        }

    }
}
