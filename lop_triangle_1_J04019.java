import java.util.Scanner;

class Point{
    private double x, y;

    Point(){}
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    static Point nextPoint(Scanner sc){
        Point ans = new Point();
        ans.x = sc.nextDouble();
        ans.y = sc.nextDouble();
        return ans;
    }

    static double distance(Point a, Point b){
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

class Triangle {
    private Point A, B, C;

    Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public boolean valid(){
        double a = Point.distance(B, C);
        double b = Point.distance(A, C);
        double c = Point.distance(A, B);
        if( a + b > c && a + c > b && b + c > a) return true;
        return false;
    }

    public String getPerimeter(){
        double a = Point.distance(B, C);
        double b = Point.distance(A, C);
        double c = Point.distance(A, B);
        return String.format("%.3f", a + b + c);
    }
}

public class lop_triangle_1_J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
