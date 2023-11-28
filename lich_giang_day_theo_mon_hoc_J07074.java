import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;

class MonHoc{
    private String id, name;
    private int amount;
    
    public MonHoc(String id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class HocPhan{
    private String idHp, idMh;
    private int dayHp, amountLess;
    private String nameLec, room;

    public static int cnt = 0;

    public HocPhan(String idMh, int dayHp, int amountLess, String nameLec, String room) {
        this.idHp = "HP" + String.format("%03d", ++cnt);
        this.idMh = idMh;
        this.dayHp = dayHp;
        this.amountLess = amountLess;
        this.nameLec = nameLec;
        this.room = room;
    }

    public int getDayHp() {
        return dayHp;
    }

    public void setDayHp(int dayHp) {
        this.dayHp = dayHp;
    }

    public String getIdHp() {
        return idHp;
    }

    public void setIdHp(String idHp) {
        this.idHp = idHp;
    }

    public String getIdMh() {
        return idMh;
    }

    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }

    public int getAmountLess() {
        return amountLess;
    }

    public void setAmountLess(int amountLess) {
        this.amountLess = amountLess;
    }

    public String getNameLec() {
        return nameLec;
    }

    public void setNameLec(String nameLec) {
        this.nameLec = nameLec;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        HocPhan.cnt = cnt;
    }

    @Override
    public String toString(){
        return this.idHp + " " + this.dayHp + " " + this.amountLess + " " + this.nameLec + " " + this.room;
    }
}

public class lich_giang_day_theo_mon_hoc_J07074 {
    public static String str;
    public static void inputMonHoc(HashMap<String, MonHoc> mapMh, String path){
        try{
            Scanner scn = new Scanner(new File(path));
            int t = scn.nextInt();
            scn.nextLine();
            while(t-- > 0){
                String idMh = scn.nextLine();
                String nameMh = scn.nextLine();
                int amountMh = Integer.parseInt(scn.nextLine());
                mapMh.put(idMh, new MonHoc(idMh, nameMh, amountMh));
            }
            scn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void inputHocPhan(ArrayList<HocPhan> arr, String path){
        try{
            Scanner scn = new Scanner(new File(path));
            int t = Integer.parseInt(scn.nextLine());
            while(t-- > 0){
                String id = scn.nextLine();
                int day = Integer.parseInt(scn.nextLine());
                int amount = Integer.parseInt(scn.nextLine());
                String nameLec = scn.nextLine();
                String room = scn.nextLine();
                arr.add(new HocPhan(id, day, amount, nameLec, room));
            }
            str = scn.nextLine();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        HashMap<String, MonHoc> mapMh = new HashMap<>();
        ArrayList<HocPhan> arr = new ArrayList<>();
        inputMonHoc(mapMh, "MONHOC.in");
        inputHocPhan(arr, "LICHGD.in");

        Collections.sort(arr, new Comparator<HocPhan>(){
            @Override
            public int compare(HocPhan o1, HocPhan o2){
                if(o1.getDayHp() != o2.getDayHp()){
                    return o1.getDayHp() - o2.getDayHp();
                }
                else{
                    if(o1.getAmountLess() == o2.getAmountLess()){
                        return o1.getNameLec().compareTo(o2.getNameLec());
                    }
                    else return o1.getAmountLess() - o2.getAmountLess();
                }
            }
        });

        System.out.println("LICH GIANG DAY MON " + mapMh.get(str).getName() + ":");
        for(HocPhan x : arr){
            if(x.getIdMh().equals(str)){
                System.out.println(x);
            }
        }
    }
}