import java.util.Scanner;

public class J01013 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        long sum = 0;
        
        //sang so nguyen to
        boolean[] isPrime = new boolean[2000005];
        for(int i=0; i<2000005; ++i){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i < 2000005; ++i){
            if(isPrime[i]){
                for(int j=i*i; j <2000005; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int[] sumDiv = new int[2000005];
        for(int i=2; i<2000005; ++i){
            if(isPrime[i]){
                for(int j = i; j<2000005; j+=i){
                    int tmp = j;
                    while(tmp%i ==0){
                        sumDiv[j] += i;
                        tmp/=i;
                    }
                }
            }
        }

        while(t-- > 0){
            int n = scn.nextInt();
            sum += sumDiv[n];
        }
        System.out.println(sum);
    }
}
