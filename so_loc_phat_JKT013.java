import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class so_loc_phat_JKT013 {
    public static void solve(int n){
        Queue<String> q = new LinkedList<>();
        q.offer("6");
        q.offer("8");
        ArrayList<String> arr = new ArrayList<>();
        while(!q.isEmpty()){
            String s = q.poll();
            arr.add(s);
            if((s +" ").length() <= n){
                q.offer(s + "6");
                q.offer(s + "8");
            }
        }
        System.out.println(arr.size());
        for(int i = arr.size() - 1; i >= 0; --i){
            System.out.print(arr.get(i)+ " ");
        }
        
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            solve(n);
            System.out.println();
        }
        scn.close();
    }
}
