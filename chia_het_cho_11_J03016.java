import java.util.Scanner;

public class chia_het_cho_11_J03016 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            String s = scn.next();
            int sumEvenIndex = 0, sumOddIndex = 0;
            for(int i = 0; i < s.length(); ++i){
                if(i%2 == 0){
                    sumEvenIndex += (s.charAt(i) - '0');
                }
                else sumOddIndex += (s.charAt(i) - '0');
            }
            int ans;
            if(Math.abs(sumOddIndex - sumEvenIndex) % 11 == 0) ans = 1;
            else ans = 0;
            System.out.println(ans);
        }
    }
}
