import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HoaDon{
    private String idCus, nameCus, room, start, finish;
    private int bonus;
    
    private static int cnt = 0;

    public HoaDon(String nameCus, String room, String start, String finish, int bonus) {
        this.idCus = "KH" + String.format("%02d", ++cnt);
        this.nameCus = nameCus.trim();
        this.room = room.trim();
        this.start = start;
        this.finish = finish;
        this.bonus = bonus;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        HoaDon.cnt = cnt;
    }

    public int dayOfStay(){
        String[] str = this.start.trim().split("/"); 
        LocalDate s = LocalDate.of(Integer.parseInt(str[2]), Integer.parseInt(str[1]), Integer.parseInt(str[0]));
        String[] end = this.finish.trim().split("/");
        LocalDate e = LocalDate.of(Integer.parseInt(end[2]), Integer.parseInt(end[1]), Integer.parseInt(end[0]));
        return (int) ChronoUnit.DAYS.between(s, e) + 1;
    }

    public int cost(){
        char c = this.room.charAt(0);
        if( c == '1') return 25;
        else if(c == '2') return 34;
        else if(c == '3') return 50;
        else return 80;
    }

    public int total(){
        return dayOfStay() * cost() + this.bonus;
    }

    @Override
    public String toString(){
        return this.idCus + " " + this.nameCus + " " + this.room + " " + this.dayOfStay() + " " + this.total();
    }
}

public class hoa_don_khach_san_J05016 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<HoaDon> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new HoaDon(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextInt()));
        }   
        Collections.sort(arr, new Comparator<HoaDon>() {

            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return o2.total() - o1.total();
            }
            
        });
        for(HoaDon x : arr){
            System.out.println(x);
        }
    }
}
