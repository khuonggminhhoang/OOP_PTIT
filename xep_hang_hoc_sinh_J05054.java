import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HocSinh{
    private String id, name;
    private double avg;
    private int rank;

    public static int cnt = 0;
    
    public HocSinh(String name, double avg) {
        this.id = "HS" + String.format("%02d", ++cnt);
        this.name = name;
        this.avg = avg;
        this.rank = 0;
    }

    public String getId(){
        return this.id;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public double getAvg(){
        return this.avg;
    }

    public String classify(){
        if(this.avg < 5) return "Yeu";
        else if(this.avg < 7) return "Trung Binh";
        else if(this.avg < 9) return "Kha";
        else return "Gioi";
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + String.format("%.1f", this.avg) + " " + this.classify() + " " + this.rank;
    }
}

public class xep_hang_hoc_sinh_J05054 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<HocSinh> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new HocSinh(scn.nextLine(), scn.nextDouble()));
        }   
        Collections.sort(arr, new Comparator<HocSinh>(){
            @Override
            public int compare(HocSinh o1, HocSinh o2){
                if(o1.getAvg() < o2.getAvg()) return 1;
                else return -1;
            }
        });
        arr.get(0).setRank(1);
        for(int i = 1; i< arr.size(); ++i){
            if(arr.get(i).getAvg() == arr.get(i-1).getAvg()){
                arr.get(i).setRank(arr.get(i-1).getRank());
            }
            else{
                arr.get(i).setRank(i + 1);
            }
        }
        Collections.sort(arr, new Comparator<HocSinh>() {

            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for(HocSinh x : arr){
            System.out.println(x);
        }
        scn.close();
    }
}
