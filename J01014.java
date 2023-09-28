import java.util.Scanner;

public class J01014 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            long ans=1;
            long n = scn.nextLong();
            for(int i=2; i< Math.sqrt(n); ++i){
                while(n%i ==0){
                    ans = i;
                    n/=i;
                }
            }
            if(n > 1) ans = n;
            System.out.println(ans);
        }

    }
}
