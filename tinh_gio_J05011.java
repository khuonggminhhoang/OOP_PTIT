import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Gamer{
    private String id, name, timeIn, timeOut;

    public Gamer(String id, String name, String timeIn, String timeOut) {
        this.id = id;
        this.name = name;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int convTime(String time){
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
    }

    public int amount(){
        return convTime(this.timeOut) - convTime(this.timeIn);
    }

    public String timeStd(int num){
        return num/60 + " gio " + num%60 + " phut";
    }

    @Override
    public String toString() {
        return this.id + "  " + this.name + " " + this.timeStd(amount());
    }

}

public class tinh_gio_J05011{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<Gamer> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new Gamer(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   
        Collections.sort(arr, new Comparator<Gamer>() {

            @Override
            public int compare(Gamer o1, Gamer o2) {
               return o2.amount() - o1.amount();
            }
            
        });
        for(Gamer x : arr){
            System.out.println(x);
        }
    }
}
