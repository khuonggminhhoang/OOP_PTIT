import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class CuaRo{
    private String id, name, province, timeFinish;

    public CuaRo(String name, String province, String timeFinish) {
        String[] s1 = name.split("\\s+");
        String[] s2 = province.split("\\s+");
        String id = "";
        for(String x : s2){
            id += x.charAt(0);
        }
        for(String x : s1){
            id += x.charAt(0);
        }
        this.id = id.toUpperCase();
        this.name = name;
        this.province = province;
        this.timeFinish = timeFinish;
    }

    public String getId(){
        return this.id;
    }

    public double time(){
        String[] a = this.timeFinish.split(":");
        double ans = 0;
        ans += Double.parseDouble(a[0]) - 6;
        ans += Double.parseDouble(a[1])/60;
        return ans;
    }

    public double speed(){
        return 120/time();
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.province + " " + Math.round(speed()) + " Km/h";
    }
}

public class dua_xe_dap_J05015 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<CuaRo> arr = new ArrayList<>();
        scn.nextLine();
        while(t-- >0){
            arr.add(new CuaRo(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   

        Collections.sort(arr, new Comparator<CuaRo>(){
            @Override
            public int compare(CuaRo o1, CuaRo o2){
                return Double.compare(o2.speed(), o1.speed());
            }
        });

        for(CuaRo x : arr){
            System.out.println(x);
        }
    }
}

