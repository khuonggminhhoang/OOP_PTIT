import java.util.Scanner;

class Rectange{
    private double width;
    private double height;
    private String color;

    Rectange(){
        this.width = 1;
        this.height = 1;
    }
    Rectange(double width, double height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }
    public String getColor() {
        return this.color;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double findArea(){
        return this.width * this.height;       
    }

    public double findPerimeter(){
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString(){
        this.color = this.color.substring(0,1).toUpperCase() + this.color.substring(1).toLowerCase();
        return (int)this.findPerimeter() + " "+ (int) this.findArea() + " " + this.color;
    }
}

public class khai_bao_lop_hinh_chu_nhat_J04002 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double width = scn.nextDouble();
        double height = scn.nextDouble();
        if(width <= 0 || height <= 0){
            System.out.println("INVALID");
            return;
        }
        Rectange a = new Rectange(Math.max(height, width), Math.min(height, width), scn.next());
        System.out.println(a);
    }
}
