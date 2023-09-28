import java.util.Scanner;

public class ma_tran_nhi_phan_J02106 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = 0;
        for(int i=0; i<n; ++i){
            int cnt = 0;
            for(int j=0; j<3; ++j){
                int x = scn.nextInt();
                if(x == 1) cnt++;
            }
            if(cnt > 1) ans++;
        }
        System.out.println(ans);
    }
}
