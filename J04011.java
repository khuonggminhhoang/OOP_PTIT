import java.util.Scanner;

class Point3D {
    private double x, y, z;

    Point3D(){}
    Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;    
    }

    public double getZ(){
        return this.z;
    }

    public Point3D vector(Point3D secondPoind){
        Point3D ans = new Point3D();
        ans.x = secondPoind.x - this.x;
        ans.y = secondPoind.y - this.y;
        ans.z = secondPoind.z - this.z;
        return ans;
    }

    static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4){
        Point3D vector12 = p1.vector(p2);
        Point3D vector13 = p1.vector(p3);

        double vctX = vector12.y * vector13.z - vector12.z * vector13.y;
        double vctY = vector12.z * vector13.x - vector12.x * vector13.z;
        double vctZ = vector12.x * vector13.y - vector12.y * vector13.x; 
        if(vctX * (p4.x -p1.x)  + vctY * (p4.y - p1.y) + vctZ * (p4.z - p1.z) == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.x + " " + this.y + " " + this.z;
    }
}

public class J04011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            
            if(Point3D.check(p1,p2,p3,p4)){
                System.out.println("YES");
            } 
            else{
                System.out.println("NO");
            }
        }
    }
}

