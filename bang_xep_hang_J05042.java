import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String name;
    private int C, T;
    public SinhVien(String name, int c, int t) {
        this.name = nameStd(name);
        C = c;
        T = t;
    }

    private String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() -1);
    }

    public String getName() {
        return name;
    }

    public int getC() {
        return C;
    }

    public int getT() {
        return T;
    }

    @Override
    public String toString() {
        return this.name + " " + this.C + " " + this.T;
    }
}

public class bang_xep_hang_J05042 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new SinhVien(scn.nextLine(), scn.nextInt(), scn.nextInt()));
        }   
        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                if(o1.getC() != o2.getC()){
                    return o2.getC() - o1.getC();
                }
                else if(o1.getT() != o2.getT()){
                    return o1.getT() - o2.getT();
                }
                else return o1.getName().compareTo(o2.getName());
            }
        });
        for(SinhVien x : arr){
            System.out.println(x);
        }
        scn.close();
    }
}
