import java.util.Scanner;

public class J01012 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int cnt = 0;
            for(int i=1; i< Math.sqrt(n); ++i){
                if(n%i == 0 ){
                    if(i%2 == 0) ++cnt;
                    if(n/i %2 == 0) ++cnt;
                }
               
            }
            if(Math.sqrt(n) == 1l * Math.sqrt(n) && 1l*Math.sqrt(n) % 2 == 0) cnt++;
            System.out.println(cnt);
        }
        
    }
}
