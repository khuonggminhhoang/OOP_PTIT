import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Nguoi{
    private String name, init, firstName, lastName;

    private String initial(String s){
        String ans = "";
        String[] arr = s.split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + ".";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public Nguoi(String name) {
        this.name = name;
        this.init = initial(name);
        String[] a = name.split("\\s+");
        this.lastName = a[0];
        this.firstName = a[a.length - 1];
    }

    public String getName() {
        return name;
    }

    public String getInit() {
        return init;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class ten_viet_tat {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("DANHSACH.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<Nguoi> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new Nguoi(scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<Nguoi>(){
            
            @Override
            public int compare(Nguoi o1, Nguoi o2) {
                if(!o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }   
                else{
                    return o1.getLastName().compareTo(o2.getLastName());
                }
            }
            
        });
        
        int q = Integer.parseInt(scn.nextLine());
        while(q-- >0){
            String s = scn.nextLine();
            int pos = s.indexOf('*');
            for(Nguoi x : arr){
                if(x.getInit().substring(0, pos).equals(s.substring(0,pos)) &&
                    x.getInit().substring(pos + 1).equals(s.substring(pos+1))){
                        System.out.println(x.getName());
                    }
            }
        }
        
        
    }

}
