import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class loai_bo_so_nguyen_J07022 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("DATA.in"));
        ArrayList<String> arr = new ArrayList<>();
        while(scn.hasNext()){
            String tmp = scn.next();
            try{
                Integer.parseInt(tmp);
            }
            catch(Exception e){
                arr.add(tmp);
            }
        }
        Collections.sort(arr);
        for(String x : arr){
            System.out.print(x + " ");
        }
    }
}
