import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day_con_co_k_phan_tu_tang_dan_J02026 {
    public static int t,n,k;
    public static int[] x = new int[15];
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static int sum(int[] a){
        int sum = 0;
        for(int i = 0; i<n; ++i){
            if(a[i] == 1){
                sum += 1;
            }
        }
        return sum;
    }

    public static void Try(int i, int[] a){
        for(int j = 0; j<2; ++j){
            x[i] = j;
            if(i == n-1){
                if(sum(x) == k){
                    ArrayList<Integer> arrTmp = new ArrayList<>();
                    for(int id = 0; id < n; ++id){
                        if(x[id] == 1){
                            arrTmp.add(a[id]);
                        }
                    }
                    arr.add(arrTmp);
                }
            }
            else Try(i  + 1, a);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        t = scn.nextInt();
        while(t-- > 0){
            arr.clear();
            n = scn.nextInt();
            k = scn.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; ++i) a[i] = scn.nextInt();
            Arrays.sort(a);
            Try(0, a);
            for(int i = arr.size() - 1; i >=0; --i){
                for(Integer y : arr.get(i)){
                    System.out.print(y + " ");
                }
                System.out.println();
            }
        }   
    }
}
