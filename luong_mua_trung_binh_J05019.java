import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

class LuongMua{
    private String id, name, start, finish;
    private int vol, time;

    public LuongMua(int i, String name, String start, String finish, int vol) {
        this.id = "T" + String.format("%02d", i);
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.vol = vol;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setVol(int vol) {
        this.vol += vol;
    };

    public void setTime(String start, String finish){
        String[] a1 = start.split(":");
        String[] a2 = finish.split(":");
        this.time += Integer.parseInt(a2[0]) * 60 + Integer.parseInt(a2[1]) - (Integer.parseInt(a1[0]) * 60 + Integer.parseInt(a1[1]));
    }

    public double avg(){
        double t = 1.0 * this.time / 60;
        return 1.0 * this.vol / t;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + String.format("%.2f", avg());
    }
}

public class luong_mua_trung_binh_J05019 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<LuongMua> arr = new ArrayList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();

        while(t-- >0){
            scn.nextLine();
            String name = scn.nextLine();
            String start = scn.nextLine();
            String finish = scn.nextLine();
            int vol = scn.nextInt();
            if(!set.contains(name)){
                set.add(name);
                arr.add(new LuongMua(set.size(), name, start, finish, vol));
                arr.get(arr.size() - 1).setTime(start, finish);
            }
            else{
                for(LuongMua x : arr){
                    if(x.getName().equals(name)){
                        x.setVol(vol);
                        x.setTime(start, finish);
                    }
                }
            }
        }   
        for(LuongMua x : arr){
            System.out.println(x);
        }
    }
}
/*
10
Dong Anh
07:30
08:00
60
Cau Giay
07:45
08:12
50
Soc Son
08:00
09:15
78
Dong Anh
18:50
20:00
88
Cau Giay
19:01
20:00
77
Soc Son
19:06
20:21
66
Dong Anh
21:00
21:40
49
Cau Giay
21:50
22:20
68
Dong Anh
22:15
23:45
30
Cau Giay
22:50
23:45
35
*/