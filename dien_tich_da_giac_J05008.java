import java.util.ArrayList;
import java.util.Scanner;

class Point{
    private double x, y;
    
    public Point(){
    }
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Point(Point p){
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
        return Math.sqrt((this.x - secondPoint.x) * (this.x - secondPoint.x) + (this.y - secondPoint.y) * (this.y - secondPoint.y));
    }
    
    public double distance(Point p1, Point p2){
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
    
    public String toString(){
        return this.x + " " + this.y;
    }
}

public class dien_tich_da_giac_J05008 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
		    ArrayList<Point> arr = new ArrayList<>();
		    int n = scn.nextInt();
		    for(int i=0; i <n; ++i){
		        arr.add(new Point(scn.nextDouble(), scn.nextDouble()));
		    }
		    double ans = 0;
		    for(int i=1; i < n ; ++i){
		        ans += arr.get(i - 1).getX() * arr.get(i).getY();
		    }
            for(int i=1; i < n ; ++i){
                ans -= arr.get(i-1).getY() * arr.get(i).getX();
            }
            ans += arr.get(n-1).getX() * arr.get(0).getY() - arr.get(n-1).getY() * arr.get(0).getX();
            System.out.println(String.format("%.3f", ans/2));
		}
        scn.close();
	}
}
