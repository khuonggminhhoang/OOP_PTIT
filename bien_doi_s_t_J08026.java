import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}

public class bien_doi_s_t_J08026 {
    public static int BFS(int a, int b){
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(new Pair(a,0));
        set.add(a);
        while(!q.isEmpty()){
            Pair head = q.poll();
            if(head.getFirst() == b) return head.getSecond();
            if(head.getFirst() < b && !set.contains(head.getFirst() * 2)){
                q.add(new Pair(head.getFirst() * 2, head.getSecond() + 1));
                set.add(head.getFirst() * 2);
            } 
            if(head.getFirst() > 1 && !set.contains(head.getFirst() - 1)){
                q.add(new Pair(head.getFirst() - 1, head.getSecond() + 1));
                set.add(head.getFirst() - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            System.out.println(BFS(a,b));
        }
    }
}
