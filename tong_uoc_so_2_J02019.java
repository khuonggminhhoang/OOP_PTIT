import java.util.Scanner;

public class tong_uoc_so_2_J02019 {
    public static int[] arr = new int[1000001];

    public static void seive(){
        for(int i=1; i <= 1000000; ++i){
            for(int j = 2*i; j <= 1000000; j += i){
                arr[j] += i;
            }
        }
    }

    public static void main(String[] args) {
        seive();
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt(), b = scn.nextInt();
        int ans = 0;
        for(int i = a; i <= b; ++i){
            if(arr[i] > i) ++ans;
        }
        System.out.println(ans);
    }
}
