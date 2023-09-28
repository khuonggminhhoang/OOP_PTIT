import java.util.ArrayList;
import java.util.Scanner;

public class hinh_sao_J08012 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[100001];

        int n = scn.nextInt();
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<=n-1; ++i){
            int u = scn.nextInt(), v = scn.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean flag = false;
        for(int i=1; i<=n; ++i){
            if(adj[i].size() == n-1){
                flag = true;
            }
        }
        System.out.println(flag ? "Yes":"No");

    }
}
