import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class IntSet{
    private TreeSet<Integer> set;

    public IntSet(){
        this.set = new TreeSet<>();
    }

    public IntSet(int[] arr){
        this.set = new TreeSet<>();
        for(int x : arr){
            this.set.add(x);
        }
    }

    public IntSet intersection(IntSet other){
        IntSet ans = new IntSet();
        for(int x : this.set){
            if(other.set.contains(x)){
                ans.set.add(x);
            }
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

public class lop_inset_2_J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
