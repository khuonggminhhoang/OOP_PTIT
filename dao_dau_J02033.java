import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dao_dau_J02033 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i <n; ++i){
            int x = scn.nextInt();
            pq.add(x);
        }
        
        long ans = 0;
        while(k-- > 0){
            int head = pq.poll();
            pq.add(-head);
        }

        for(int x : pq){
            ans += x;
        }

        System.out.println(ans);
    }
}
