import java.util.Scanner;

class Point{
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint){
        return Math.sqrt((this.x - secondPoint.x)*(this.x - secondPoint.x) + (this.y - secondPoint.y)*(this.y - secondPoint.y));
    }

    static double distance(Point p1, Point p2){
        return Math.sqrt((p1.x - p2.x)* (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    @Override
    public String toString(){
        return "";
    }
}

public class chu_vi_tam_giac_J04008 {
    public static double check(Point p1, Point p2, Point p3){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p1, p3);
        if( a + b > c && b + c > a && a + c > b) return a + b + c;
        return -1;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){

            Point p1 = new Point(scn.nextDouble(), scn.nextDouble());
            Point p2 = new Point(scn.nextDouble(), scn.nextDouble());
            Point p3 = new Point(scn.nextDouble(), scn.nextDouble());
            double tmp = check(p1, p2, p3);
            if(tmp> 0){
                System.out.println(String.format("%.3f", tmp));
            }
            else{
                System.out.println("INVALID");
            }
        }
    }
}
