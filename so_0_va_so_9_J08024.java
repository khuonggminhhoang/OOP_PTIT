import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class so_0_va_so_9_J08024 {
    public static long solve(int n){
        Queue<String> q = new LinkedList<>();
        q.offer("9");
        while(true){
            String first =q.poll();
            long num = Long.parseLong(first);
            if(num % n == 0) return num;
            q.offer(first + "0");
            q.offer(first + "9");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            System.out.println(solve(n));
        } 
    }
}
