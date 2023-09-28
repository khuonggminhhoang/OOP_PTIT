import java.util.Scanner;
import java.util.TreeSet;

class IntSet {
    private TreeSet <Integer> set;
    IntSet(){
        this.set = new TreeSet<>();
    }
    IntSet(int[] a){
        this.set = new TreeSet<>();
        for(int i=0; i<a.length; ++i){
            this.set.add(a[i]);
        }
    }

    public IntSet union(IntSet secondIntSet){
        IntSet ans = new IntSet();
        for(int x : this.set){
            ans.set.add(x);
        }
        for(int x : secondIntSet.set){
            ans.set.add(x);
        }
        return ans;
    }

    @Override
    public String toString(){
        String ans = "";
        for(int x : this.set){
            ans += x + " ";
        }
        return ans;
    }
}

public class lop_inset_J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
