import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class CaThi{
    private String id, room;

    private Date time;

    private Date date;

    public static int cnt = 0;
    public CaThi(String date, String time, String room) throws ParseException {
        this.id = "C" + String.format("%03d", ++cnt);
        this.date = (new SimpleDateFormat("dd/MM/yyyy")).parse(date);
        this.time = (new SimpleDateFormat("HH:mm")).parse(time);
        this.room = room;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/') sb.insert(0,'0');
        if(sb.charAt(4) == '/') sb.insert(3,'0');
        return sb.toString();
    }

    private String timeStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == ':'){
            sb.insert(0,'0');
        }
        if(sb.length() == 4){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    public String getDate(){
        return (new SimpleDateFormat("dd/MM/yyyy")).format(date);
    }

    public String getId(){
        return this.id;
    }

    public String getTime(){
        return (new SimpleDateFormat("HH:mm")).format(this.time);
    }

    @Override
    public String toString() {
        return this.id + " " + getDate() + " " + getTime() + " " + this.room;
    }
}

public class danh_sach_ca_thi_J07059 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("CATHI.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<CaThi> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new CaThi(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<CaThi>(){

            @Override
            public int compare(CaThi o1, CaThi o2) {
                if(!o1.getDate().equals(o2.getDate())){
                    return o1.getDate().compareTo(o2.getDate());
                }
                if(!o1.getTime().equals(o2.getTime())){
                    return o1.getTime().compareTo(o2.getTime());
                }
                else{
                    return o1.getId().compareTo(o2.getId());
                }
            }
            
        });
        for(CaThi x : arr){
            System.out.println(x);
        }
    }
}
