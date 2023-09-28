import java.util.Scanner;

class Point {
    private double x, y;

    Point(){}

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double distance(Point secondPoint){
        double ans = Math.sqrt((this.x - secondPoint.x) * (this.x - secondPoint.x) + (this.y - secondPoint.y) * (this.y - secondPoint.y));
        return ans;
    }

    public double distance(Point p1, Point p2){
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}

public class dien_tich_tam_giac_J04009 {
    public static boolean isTriangle(Point p1, Point p2, Point p3){
        double dis1 = p1.distance(p2);
        double dis2 = p1.distance(p3);
        double dis3 = p2.distance(p3);

        if(dis1 + dis2 > dis3 && dis2 + dis3 > dis1 && dis1 + dis3 > dis2){
            return true;
        }
        return false;
    }

    public static String solve(Point p1, Point p2, Point p3){
        if(!isTriangle(p1, p2, p3)){
            return "INVALID";
        }
        double dis1 = p1.distance(p2);
        double dis2 = p1.distance(p3);
        double dis3 = p2.distance(p3);

        double ans = 0.25 * Math.sqrt((dis1 + dis2 + dis3) * (dis1 + dis2 - dis3)
                            * (dis1 - dis2 + dis3) * (-dis1 + dis2 + dis3));
        return String.format("%.2f",ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            Point p1 = new Point(scn.nextDouble(), scn.nextDouble());
            Point p2 = new Point(scn.nextDouble(), scn.nextDouble());
            Point p3 = new Point(scn.nextDouble(), scn.nextDouble());
            System.out.println(solve(p1, p2, p3));
        }
        
    }
}
