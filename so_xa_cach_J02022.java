import java.util.Scanner;

public class so_xa_cach_J02022 {
    public static int[] a = new int[11];
    public static boolean[] visited = new boolean[11];
    public static int n; 

    public static boolean check(){
        for(int i=1; i<n; ++i){
            if(Math.abs(a[i+1] - a[i]) == 1) return false;
        }
        return true;
    }

    public static void Try(int i){
        for(int j= 1; j <= n; ++j){
            if(visited[j] == false){
                a[i] = j;
                visited[j] = true;
                if(i == n && check()){
                    for(int idx=1; idx<=n; ++idx){
                        System.out.print(a[idx]);
                    }
                    System.out.println();
                }
                else Try(i+1);
                visited[j] = false;
            }

        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            n = scn.nextInt();
            Try(1);
        }
    }
}
