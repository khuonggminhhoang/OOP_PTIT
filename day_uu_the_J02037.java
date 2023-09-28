import java.util.Scanner;

public class day_uu_the_J02037 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){  
            int cntOdd = 0, cntEven = 0;
            String s = scn.nextLine();
            String[] arr = s.trim().split("\\s+");
            int size = arr.length;
            for(String st : arr){
                int x = Integer.parseInt(st);
                if(x % 2 == 0){
                    cntEven++;
                }
                else cntOdd++;
            }
            
            if((size % 2 == 0 && cntEven > cntOdd) || (size % 2 != 0 && cntEven < cntOdd)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}

