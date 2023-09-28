import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Pair<T, U> {
    private int first;
    private int second;

    Pair( int first, int second){
        this.first = first;
        this.second = second;
    }

    public static boolean isPrime1(int a){
        for(int i=2; i<= Math.sqrt(a); ++i){
            if(a % i == 0) return false;
        }
        return a > 1;
    }

    public boolean isPrime(){ 
        return isPrime1((int) this.first) && isPrime1((int) this.second);
    }

    @Override
    public String toString(){
        return this.first + " " + this.second;
    }
}

public class lop_pair_generic_J07017 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
