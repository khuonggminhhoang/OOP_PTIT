import java.util.ArrayList;
import java.util.Scanner;

class ThiSinh{
    private int id;
    private String name, birthday;
    private double mark1, mark2, mark3;

    public static int cnt = 0;
    public ThiSinh(String name, String birthday, double mark1, double mark2, double mark3) {
        this.id = ++cnt;
        this.name = name;
        this.birthday = birthday;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public double getMark(){
        return this.mark1 + this.mark2 + this.mark3;
    }

    @Override
    public String toString(){
        return this.id + " "+ this.name + " " + this.birthday + " " + this.getMark();
    }
}

public class tim_thu_khoa_cua_ky_thi_J05009 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        double max = -1;
        ArrayList<ThiSinh> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            ThiSinh ts = new ThiSinh(scn.nextLine(), scn.nextLine(), scn.nextDouble(),scn.nextDouble(), scn.nextDouble());
            arr.add(ts);
            max = Math.max(max, ts.getMark());
        }
        for(ThiSinh x : arr){
            if(x.getMark() == max){
                System.out.println(x);
            }
        }
    }
    
}
