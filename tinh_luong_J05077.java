import java.util.HashMap;
import java.util.Scanner;

class NhanVien {
    private String id, name;
    private int basicSalary, workDay;

    public static HashMap<String, String> map = new HashMap<>();

    private static int[][] coef = {
            {10, 12, 14, 20},
            {10, 11, 13, 16},
            {9, 10, 12, 14},
            {8, 9, 11, 13}
        };

    public NhanVien( String id, String name, int basicSalary, int workDay) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.workDay = workDay;
        
    }

    public int coef(){
        int i = (this.id.charAt(0) - 'A');
        int tmp = Integer.parseInt(this.id.substring(1,3));
        int j = 0;
        if(1 <= tmp && tmp <= 3) j = 0;
        else if(4 <= tmp && tmp <=8) j = 1;
        else if(9 <= tmp && tmp <=15) j = 2;
        else j = 3;
        return coef[i][j];
    }

    public int total(){
        return this.basicSalary * this.workDay * this.coef() * 1000;
    }

    @Override 
    public String toString(){
        return this.id + " " + this.name + " " + map.get(this.id.substring(3)) + " " + this.total();
    }
}

public class tinh_luong_J05077 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            NhanVien.map.put(scn.next(), scn.nextLine());
        }
        
        int n = scn.nextInt();
        while(n-- > 0){
            scn.nextLine();
            NhanVien x = new NhanVien(scn.nextLine(), scn.nextLine(), scn.nextInt(), scn.nextInt());
            System.out.println(x);
        }
        scn.close();
    }
}