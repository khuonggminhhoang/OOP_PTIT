import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class VanDongVien {
    private String id, name, dateOfBirth;
    private String start, finish;
    private int rank;

    public static int cnt = 0;

    public VanDongVien(String name, String dateOfBirth, String start, String finish){
        this.id = "VDV" + String.format("%02d", ++cnt);
        this.name = name;
        this.dateOfBirth = dayStd(dateOfBirth);
        this.start = start;
        this.finish = finish;
        this.rank = 0;
    }
    
    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
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

    public int convIntTime(String s){
        return Integer.parseInt(s.substring(0,2)) * 3600 + 
                Integer.parseInt(s.substring(3, 5)) * 60 + 
                Integer.parseInt(s.substring(6));
    }

    public String convStrTime(int n){
        int h = n/3600;
        n %= 3600;
        int m = n/60;
        n %= 60;
        int s = n;
        return String.format("%02d",h) + ":" + String.format("%02d",m) + ":" + String.format("%02d",s);
    }

    public String achieve(){
        int n = convIntTime(this.start);
        int m = convIntTime(this.finish);
        int tmp = m - n;
        return convStrTime(tmp);
    }

    public String priority(){
        int year = Integer.parseInt(this.dateOfBirth.substring(6));
        int ans = 2021 - year;
        if(ans < 18) return "00:00:00";
        else if(ans < 25) return "00:00:01";
        else if(ans < 32) return "00:00:02";
        else return "00:00:03";
    }

    public String rankTime(){
        String tmp = convStrTime(convIntTime(this.achieve()) - convIntTime(priority()));
        return tmp;
    }

    @Override
    public String toString(){
        
        return this.id + " " + this.name + " " + this.achieve() + " " + this.priority() + " " + this.rankTime() + " " + this.rank;
    }
}

public class xep_hang_van_dong_vien_J05055 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<VanDongVien> arr = new ArrayList<>();
        while( t-- >0){
            arr.add(new VanDongVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<VanDongVien>() {

            @Override
            public int compare(VanDongVien o1, VanDongVien o2) {
                int x1 = o1.convIntTime(o1.rankTime());
                int x2 = o2.convIntTime(o2.rankTime());
                return x1 - x2;
            }
            
        });

        arr.get(0).setRank(1);
        for(int i = 1; i <arr.size(); ++i){
            if(arr.get(i).rankTime().equals(arr.get(i-1).rankTime())){
                arr.get(i).setRank(arr.get(i-1).getRank());
            }
            else{
                arr.get(i).setRank(i + 1);
            }
        }

        // Collections.sort(arr, new Comparator<VanDongVien>() {

        //     @Override
        //     public int compare(VanDongVien o1, VanDongVien o2) {
        //         return o1.getId().compareTo(o2.getId());
        //     }
            
        // });

        for(VanDongVien x : arr){
            System.out.println(x);
        }
    }
}
