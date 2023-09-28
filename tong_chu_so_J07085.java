import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;

public class tong_chu_so_J07085 {
    public static int sum(String s){
        int sum =0;
        for(char x : s.toCharArray()){
            sum += (x - '0');
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> arr = (ArrayList<String>) input.readObject();
        for(String x : arr){
            String tmp = "";
            for(char i : x.toCharArray()){
                if(Character.isDigit(i)){
                    tmp +=i;
                }
            }
            BigInteger num = new BigInteger(tmp);
            System.out.println(num + " " + sum(tmp));
        }
    }
}
