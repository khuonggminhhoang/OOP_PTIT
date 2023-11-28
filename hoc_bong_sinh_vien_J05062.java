import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String name;
    private double TBC;
    private int RL;

    public SinhVien(String name, double tBC, int rL) {
        this.name = name;
        TBC = tBC;
        RL = rL;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTBC() {
        return TBC;
    }

    public void setTBC(double tBC) {
        TBC = tBC;
    }

    public int getRL() {
        return RL;
    }

    public void setRL(int rL) {
        RL = rL;
    }    

    public String classify(){
        if(this.TBC >= 3.6 && this.RL >= 90) return "XUATSAC";
        else if(this.TBC >= 3.6 && this.RL >= 80) return "GIOI";
        else if(this.TBC >= 2.5 && this.RL >= 70) return "KHA";
        else return "KHONG";
    }
}

public class hoc_bong_sinh_vien_J05062 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        for(int i=0; i<n; ++i){
            scn.nextLine();
            arr.add(new SinhVien(scn.nextLine(), scn.nextDouble(), scn.nextInt()));
        }

        ArrayList<SinhVien> arrCopy = new ArrayList<>();
        arrCopy.addAll(arr);

        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                if(o1.getTBC() != o2.getTBC()){
                    return Double.compare(o2.getTBC(), o1.getTBC());
                }
                else{
                    return o2.getRL() - o1.getRL();
                }
            }
        });

        double tbc = 0;
        for(int i =0; i<m; ++i){
            tbc = arr.get(i).getTBC();
        }
        
        for(SinhVien x : arrCopy){
            if(x.getTBC() >= tbc){
                System.out.println(x.getName() + ": " + x.classify());
            }
            else{
                System.out.println(x.getName() + ": KHONG");
            }
        }
    }
}
