import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Time{
    private int hour, min, sec;

    Time(){}
    Time(int hour, int min, int sec){
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getTime(){
        return this.hour * 3600 + this.min * 60 + this.sec;
    }

    @Override
    public String toString(){
        return this.hour + " " + this.min + " " + this.sec;
    }
}

public class sap_xep_thoi_gian_J05033 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList <Time> arr = new ArrayList<>();
        while(t-- > 0){
            Time time = new Time(scn.nextInt(), scn.nextInt(), scn.nextInt());
            arr.add(time);
        }
        Collections.sort(arr, new Comparator<Time>(){

            @Override
            public int compare(Time o1, Time o2) {
                return o1.getTime() - o2.getTime();
            }

        });

        for(Time x : arr){
            System.out.println(x);
        }
    }
}
