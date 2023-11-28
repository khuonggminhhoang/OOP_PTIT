import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T, S>{
    public T first;
    public S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
}

public class quan_ma_J08029 {
    public static int[] dx = {-2, 2, -2, 2, -1, -1, 1, 1},
                        dy = {-1, -1, 1, 1, -2, 2, -2, 2};

    public static int solve(String s1, String s2){
        int[][] x = new int[9][9];
        for(int i = 1; i<9; ++i){
            for(int j = 1; j < 9; ++j){
                x[i][j] = 0;
            }
        }

        int a = 8 - (s1.charAt(1) - '0') + 1;
        int b = s1.charAt(0) - 'a' + 1;
        int c = 8 - (s2.charAt(1) - '0') + 1;
        int d = s2.charAt(0) - 'a' + 1;
        
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(new Pair<>(a,b), 0));
        x[a][b] = 1;

        while(!q.isEmpty()){
            Pair<Pair<Integer, Integer>, Integer> head = q.poll();
            int i = head.first.first, j = head.first.second;
            if(c == i && d == j){
                return head.second;
            }
            for(int k=0; k<=7; ++k){
                if((i + dx[k]) >= 1 && (i + dx[k]) <= 8 && (j + dy[k]) >= 1 && (j + dy[k]) <= 8 && x[i + dx[k]][j + dy[k]] == 0){
                    x[i + dx[k]][j + dy[k]] = 1;
                    q.add(new Pair<>(new Pair<>(i + dx[k], j + dy[k]) , head.second + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String[] s = scn.nextLine().split("\\s+");
            System.out.println(solve(s[0], s[1]));
        }
    }
}
